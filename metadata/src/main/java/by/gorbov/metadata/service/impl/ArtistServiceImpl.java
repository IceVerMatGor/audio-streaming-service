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

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Override
    public ArtistDto getById(Long id) {
        return artistMapper.toDto(artistRepository.getById(id));
    }

    @Override
    public List<ArtistDto> getAll() {
        return null;
    }

    @Override
    public void delete(ArtistDto artistDto) {
        artistRepository.delete(artistMapper.toEntity(artistDto));
    }

    @Override
    public void save(ArtistDto artistDto) {

    }

    @Override
    public void update(ArtistDto artistDto) {
        return null;
    }
}
