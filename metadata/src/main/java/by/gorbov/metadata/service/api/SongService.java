package by.gorbov.metadata.service.api;

import by.gorbov.metadata.dto.SongDto;

import java.util.List;

public interface SongService {

    SongDto getById(Long id);

    List<SongDto> getAll();
}
