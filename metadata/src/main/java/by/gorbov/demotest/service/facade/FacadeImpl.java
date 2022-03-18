package by.gorbov.demotest.service.facade;

import by.gorbov.demotest.dto.*;
import by.gorbov.demotest.service.api.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacadeImpl implements Facade {

    private final AlbumService albumService;
    private final ArtistService artistService;
    private final GenreService genreService;
    private final ResourceService resourceService;
    private final SongService songService;
    private final StorageService storageService;

    public FacadeImpl(AlbumService albumService, ArtistService artistService,
                      GenreService genreService, ResourceService resourceService,
                      SongService songService, StorageService storageService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.genreService = genreService;
        this.resourceService = resourceService;
        this.songService = songService;
        this.storageService = storageService;
    }

    @Override
    public List<AlbumDto> getAllAlbum() {
        return albumService.getAll();
    }

    @Override
    public AlbumDto getByIdAlbum(Long id) {
        return albumService.getById(id);
    }

    @Override
    public void deleteAlbum(AlbumDto dto) {
        albumService.delete(dto);
    }

    @Override
    public void saveAlbum(AlbumDto dto) {
        albumService.save(dto);
    }

    @Override
    public void updateAlbum(AlbumDto dto) {
        albumService.update(dto);
    }

    @Override
    public List<ArtistDto> getAllArtist() {
        return artistService.getAll();
    }

    @Override
    public ArtistDto getByIdArtist(Long id) {
        return artistService.getById(id);
    }

    @Override
    public void deleteArtist(ArtistDto dto) {
        artistService.delete(dto);
    }

    @Override
    public void saveArtist(ArtistDto dto) {
        artistService.save(dto);
    }

    @Override
    public void updateArtist(ArtistDto dto) {
        artistService.update(dto);
    }

    @Override
    public List<GenreDto> getAllGenre() {
        return genreService.getAll();
    }

    @Override
    public GenreDto getByIdGenre(Long id) {
        return genreService.getById(id);
    }

    @Override
    public void deleteGenre(GenreDto dto) {
        genreService.delete(dto);
    }

    @Override
    public void saveGenre(GenreDto dto) {
        genreService.save(dto);
    }

    @Override
    public void updateGenre(GenreDto dto) {
        genreService.update(dto);
    }

    @Override
    public List<ResourceDto> getAllResource() {
        return resourceService.getAll();
    }

    @Override
    public ResourceDto getByIdResource(Long id) {
        return resourceService.getById(id);
    }

    @Override
    public void deleteResource(ResourceDto dto) {
        resourceService.delete(dto);
    }

    @Override
    public void saveResource(ResourceDto dto) {
        resourceService.save(dto);
    }

    @Override
    public void updateResource(ResourceDto dto) {
        resourceService.update(dto);
    }

    @Override
    public List<SongDto> getAllSong() {
        return songService.getAll();
    }

    @Override
    public SongDto getByIdSong(Long id) {
        return songService.getById(id);
    }

    @Override
    public void deleteSong(SongDto dto) {
        songService.delete(dto);
    }

    @Override
    public void saveSong(SongDto dto) {
        songService.save(dto);
    }

    @Override
    public void updateSong(SongDto dto) {
        songService.update(dto);
    }

    @Override
    public List<StorageDto> getAllStorage() {
        return storageService.getAll();
    }

    @Override
    public StorageDto getByIdStorage(Long id) {
        return storageService.getById(id);
    }

    @Override
    public void deleteStorage(StorageDto dto) {
        storageService.delete(dto);
    }

    @Override
    public void saveStorage(StorageDto dto) {
        storageService.save(dto);
    }

    @Override
    public void updateStorage(StorageDto dto) {
        storageService.update(dto);
    }
}
