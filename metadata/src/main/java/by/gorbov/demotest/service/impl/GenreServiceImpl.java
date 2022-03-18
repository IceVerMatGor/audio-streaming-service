package by.gorbov.demotest.service.impl;

import by.gorbov.demotest.dto.GenreDto;
import by.gorbov.demotest.dto.mapper.api.GenreMapper;
import by.gorbov.demotest.dto.mapper.api.Mapper;
import by.gorbov.demotest.entity.Genre;
import by.gorbov.demotest.repo.GenreRepository;
import by.gorbov.demotest.service.api.GenreService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends AbstractService<GenreDto, Genre> implements GenreService {

    public GenreServiceImpl(JpaRepository<Genre, Long> repository, GenreMapper mapper) {
        super(repository, mapper);
    }
}
