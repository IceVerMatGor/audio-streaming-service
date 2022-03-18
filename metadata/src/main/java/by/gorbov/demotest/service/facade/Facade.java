package by.gorbov.demotest.service.facade;

import by.gorbov.demotest.dto.*;

import java.util.List;

public interface Facade {
    List<AlbumDto> getAllAlbum();

    AlbumDto getByIdAlbum(Long id);

    void deleteAlbum(AlbumDto dto);

    void saveAlbum(AlbumDto dto);

    void updateAlbum(AlbumDto dto);

    List<ArtistDto> getAllArtist();

    ArtistDto getByIdArtist(Long id);

    void deleteArtist(ArtistDto dto);

    void saveArtist(ArtistDto dto);

    void updateArtist(ArtistDto dto);

    List<GenreDto> getAllGenre();

    GenreDto getByIdGenre(Long id);

    void deleteGenre(GenreDto dto);

    void saveGenre(GenreDto dto);

    void updateGenre(GenreDto dto);

    List<ResourceDto> getAllResource();

    ResourceDto getByIdResource(Long id);

    void deleteResource(ResourceDto dto);

    void saveResource(ResourceDto dto);

    void updateResource(ResourceDto dto);

    List<SongDto> getAllSong();

    SongDto getByIdSong(Long id);

    void deleteSong(SongDto dto);

    void saveSong(SongDto dto);

    void updateSong(SongDto dto);

    List<StorageDto> getAllStorage();

    StorageDto getByIdStorage(Long id);

    void deleteStorage(StorageDto dto);

    void saveStorage(StorageDto dto);

    void updateStorage(StorageDto dto);
}
