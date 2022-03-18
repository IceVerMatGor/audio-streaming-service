package by.gorbov.demotest.controller;

import by.gorbov.demotest.dto.SongDto;
import by.gorbov.demotest.service.facade.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/songs")
public class SongController {
    private final Facade facade;

    public SongController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<SongDto> getAll() {
        return facade.getAllSong();
    }

    @GetMapping("/{id}")
    public SongDto getById(@PathVariable Long id) {
        return facade.getByIdSong(id);
    }

    @DeleteMapping
    public void delete(@RequestBody SongDto song) {
        facade.deleteSong(song);
    }

    @PostMapping
    public void create(@RequestBody SongDto song) {
        facade.saveSong(song);
    }

    @PutMapping
    public void update(@RequestBody SongDto song) {
        facade.updateSong(song);
    }

}
