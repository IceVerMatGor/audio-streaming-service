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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreDto getById(Long id) {
        log.info("get genre {}",id);
        return genreMapper.toDto(genreRepository.getById(id));
    }

    @Override
    public List<GenreDto> getAll() {
        log.info("get all genres");
        List<GenreDto> genres = new ArrayList<>();
        genreRepository.findAll().forEach(genre -> genres.add( genreMapper.toDto(genre)));
        return genres;

    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void save(GenreDto genreDto) {
        log.info("save genre {}",genreDto.getName());
        genreRepository.save(genreMapper.toEntity(genreDto));
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    @Override
    public void update(GenreDto newGenre) {
        log.info("update genre {}",newGenre.getId());
        genreRepository.save(genreMapper.toEntity(newGenre));
    }
}
