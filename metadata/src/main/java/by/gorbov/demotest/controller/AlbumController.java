package by.gorbov.demotest.controller;

import by.gorbov.demotest.dto.AlbumDto;
import by.gorbov.demotest.service.facade.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/albums")
public class AlbumController {
    private final Facade facade;

    public AlbumController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<AlbumDto> getAll() {
        return facade.getAllAlbum();
    }

    @GetMapping("/{id}")
    public AlbumDto getById(@PathVariable Long id) {
        return facade.getByIdAlbum(id);
    }

    @DeleteMapping
    public void delete(@RequestBody AlbumDto album) {
        facade.deleteAlbum(album);
    }

    @PostMapping
    public void create(@RequestBody AlbumDto album) {
        facade.saveAlbum(album);
    }

    @PutMapping
    public void update(@RequestBody AlbumDto album) {
        facade.updateAlbum(album);
    }
}
