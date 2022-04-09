package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.SongDto;
import by.gorbov.metadata.dto.mapper.api.SongMapper;
import by.gorbov.metadata.entity.Song;
import by.gorbov.metadata.repo.SongRepository;
import by.gorbov.metadata.service.api.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Override
    public SongDto getById(Long id) {
        log.info("get song {}",id);
        return songMapper.toDto(songRepository.getById(id));
    }

    @Override
    public List<SongDto> getAll() {
        log.info("get all songs");
        List<SongDto> songs = new ArrayList<>();
        songRepository.findAll().forEach(song -> songs.add(songMapper.toDto(song)));
        return songs;
    }
}
