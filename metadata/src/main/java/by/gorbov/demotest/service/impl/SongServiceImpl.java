package by.gorbov.demotest.service.impl;

import by.gorbov.demotest.dto.SongDto;
import by.gorbov.demotest.dto.mapper.api.Mapper;
import by.gorbov.demotest.dto.mapper.api.SongMapper;
import by.gorbov.demotest.entity.Song;
import by.gorbov.demotest.service.api.SongService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl extends AbstractService<SongDto, Song> implements SongService {


    public SongServiceImpl(JpaRepository<Song, Long> repository, SongMapper mapper) {
        super(repository, mapper);
    }
}
