package by.gorbov.metadata.service.api;

import by.gorbov.metadata.dto.GenreDto;

import java.util.List;

public interface GenreService {

    GenreDto getById(Long id);

    List<GenreDto> getAll();

    void save(GenreDto genreDto);

    void update(GenreDto newGenre);
}
