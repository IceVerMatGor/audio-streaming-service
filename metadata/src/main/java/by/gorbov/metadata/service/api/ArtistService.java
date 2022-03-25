package by.gorbov.metadata.service.api;

import by.gorbov.metadata.dto.ArtistDto;

import java.util.List;

public interface ArtistService {

    ArtistDto getById(Long Id);

    List<ArtistDto> getAll();

    void delete(ArtistDto artistDto);

    void save(ArtistDto artistDto);

    void update(ArtistDto artistDto);
}
