package by.gorbov.demotest.service.impl;

import by.gorbov.demotest.dto.AlbumDto;
import by.gorbov.demotest.dto.mapper.api.AlbumMapper;
import by.gorbov.demotest.dto.mapper.api.Mapper;
import by.gorbov.demotest.entity.Album;
import by.gorbov.demotest.repo.AlbumRepository;
import by.gorbov.demotest.service.api.AlbumService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends AbstractService<AlbumDto, Album> implements AlbumService {


    public AlbumServiceImpl(JpaRepository<Album, Long> repository, AlbumMapper mapper) {
        super(repository, mapper);
    }
}
