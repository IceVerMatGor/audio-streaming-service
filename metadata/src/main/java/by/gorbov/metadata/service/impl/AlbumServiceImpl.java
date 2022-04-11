package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.AlbumDto;
import by.gorbov.metadata.dto.ResourceDto;
import by.gorbov.metadata.dto.SongDto;
import by.gorbov.metadata.dto.mapper.api.AlbumMapper;
import by.gorbov.metadata.entity.AbstractEntity;
import by.gorbov.metadata.entity.Album;
import by.gorbov.metadata.entity.Song;
import by.gorbov.metadata.repo.AlbumRepository;
import by.gorbov.metadata.service.api.AlbumService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public List<AlbumDto> getAll() {
        log.info("get all albums");
        List<AlbumDto> albums = new ArrayList<>();
        albumRepository.findAll().forEach(album -> albums.add(albumMapper.toDto(album)));
        return albums;
    }

    @Override
    public AlbumDto getById(Long id) {
        log.info("get album {}", id);
        return albumMapper.toDto(albumRepository.getById(id));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void save(AlbumDto albumDto) {
        log.info("save album {}", albumDto.getName());
        Album album = albumMapper.toEntity(albumDto);
        album.getSongs().forEach(song -> {
            song.setAlbum(album);
            song.setYear(album.getYear());
        });
        albumRepository.save(album);
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void update(AlbumDto newAlbum) {
        log.info("update album {}", newAlbum.getId());
        Album album = albumMapper.toEntity(newAlbum);
        album.getSongs().forEach(song -> song.setAlbum(album));

        RestTemplate restTemplate = new RestTemplate();
        List<ResourceDto> list = new ArrayList<>();
        album.getSongs().forEach(song -> {
            song.setResourceId(song.getId());
            list.add(ResourceDto.builder()
                    .songId(song.getId())
                    .id(song.getId())
                    .storageId(1L)
                    .build());
        });
        HttpEntity<List<ResourceDto>> entities = new HttpEntity<>(list);
        restTemplate.exchange("http://localhost:8082/api/v2/resources", HttpMethod.POST, entities, ResourceDto.class);

        albumRepository.save(album);
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void delete(AlbumDto albumDto) {
        log.info("delete album {}", albumDto.getId());
        RestTemplate restTemplate = new RestTemplate();
        List<Long> resourcesIds = new ArrayList<>();
        albumDto.getSongs().forEach(songDto -> resourcesIds.add(songDto.getResourceId()));
        HttpEntity<List<Long>> deleteIds = new HttpEntity<>(resourcesIds);
        restTemplate.exchange("http://localhost:8082/api/v1/resources", HttpMethod.DELETE, deleteIds, Long.class);

        albumRepository.delete(albumMapper.toEntity(albumDto));
    }
}
