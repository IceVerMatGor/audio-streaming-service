package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.GenreDto;
import by.gorbov.metadata.dto.mapper.api.GenreMapper;
import by.gorbov.metadata.entity.Genre;
import by.gorbov.metadata.repo.GenreRepository;
import by.gorbov.metadata.service.api.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreDto getById(Long id) {
        return genreMapper.toDto(genreRepository.getById(id));
    }

    @Override
    public List<GenreDto> getAll() {
        return null;
    }

    @Override
    public void save(GenreDto genreDto) {
        genreRepository.save(genreMapper.toEntity(genreDto));
    }

    @Override
    public void update(GenreDto newGenre) {

    }
}
