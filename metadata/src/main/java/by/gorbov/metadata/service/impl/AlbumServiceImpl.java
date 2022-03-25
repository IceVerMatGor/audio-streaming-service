package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.AlbumDto;
import by.gorbov.metadata.dto.mapper.api.AlbumMapper;
import by.gorbov.metadata.entity.Album;
import by.gorbov.metadata.repo.AlbumRepository;
import by.gorbov.metadata.service.api.AlbumService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public List<AlbumDto> getAll() {
        return null;
    }

    @Override
    public AlbumDto getById(Long id) {
        return albumMapper.toDto(albumRepository.getById(id));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = SQLException.class)
    @Override
    public void save(AlbumDto albumDto) {
        albumRepository.save(albumMapper.toEntity(albumDto));
    }

    @Override
    public void update(AlbumDto newAlbum) {

    }

    @Override
    public void delete(AlbumDto albumDto) {

    }
}
