package by.gorbov.metadata.service.api;


import by.gorbov.metadata.dto.AlbumDto;

import java.util.List;

public interface AlbumService {

    List<AlbumDto> getAll();

    AlbumDto getById(Long id);

    void save(AlbumDto albumDto);

    void update(AlbumDto newAlbum);

    void delete(AlbumDto albumDto);




}
