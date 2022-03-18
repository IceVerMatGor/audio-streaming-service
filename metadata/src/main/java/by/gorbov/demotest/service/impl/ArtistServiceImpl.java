package by.gorbov.demotest.service.impl;

import by.gorbov.demotest.dto.ArtistDto;
import by.gorbov.demotest.dto.mapper.api.ArtistMapper;
import by.gorbov.demotest.dto.mapper.api.Mapper;
import by.gorbov.demotest.entity.Artist;
import by.gorbov.demotest.repo.ArtistRepository;
import by.gorbov.demotest.service.api.ArtistService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl extends AbstractService<ArtistDto, Artist> implements ArtistService {

    public ArtistServiceImpl(JpaRepository<Artist, Long> repository, ArtistMapper mapper) {
        super(repository, mapper);
    }
}
