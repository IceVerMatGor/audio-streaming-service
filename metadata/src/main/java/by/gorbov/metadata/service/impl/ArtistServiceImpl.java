package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.ArtistDto;
import by.gorbov.metadata.dto.mapper.api.ArtistMapper;
import by.gorbov.metadata.entity.Artist;
import by.gorbov.metadata.repo.ArtistRepository;
import by.gorbov.metadata.service.api.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Override
    public ArtistDto getById(Long id) {
        log.info("get artist {}", id);
        return artistMapper.toDto(artistRepository.getById(id));
    }

    @Override
    public List<ArtistDto> getAll() {
        log.info("get all artists");
        List<ArtistDto> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artist -> artists.add(artistMapper.toDto(artist)));
        return artists;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void delete(ArtistDto artistDto) {
        log.info("delete artist {}", artistDto.getId());
        artistRepository.delete(artistMapper.toEntity(artistDto));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void save(ArtistDto artistDto) {
        log.info("save arist {}", artistDto.getName());
        artistRepository.save(artistMapper.toEntity(artistDto));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void update(ArtistDto artistDto) {
        log.info("update arist {}", artistDto.getId());
        artistRepository.save(artistMapper.toEntity(artistDto));
    }
}
