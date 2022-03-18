package by.gorbov.demotest.controller;

import by.gorbov.demotest.dto.ArtistDto;
import by.gorbov.demotest.dto.GenreDto;
import by.gorbov.demotest.service.facade.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/artists")
public class ArtistController {
    private final Facade facade;

    public ArtistController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<ArtistDto> getAll() {
        return facade.getAllArtist();
    }

    @GetMapping("/{id}")
    public ArtistDto getById(@PathVariable Long id) {
        return facade.getByIdArtist(id);
    }

    @DeleteMapping
    public void delete(@RequestBody ArtistDto artist) {
        facade.deleteArtist(artist);
    }

    @PostMapping
    public void create(@RequestBody ArtistDto artist) {
        facade.saveArtist(artist);
    }

    @PutMapping
    public void update(@RequestBody ArtistDto artist) {
        facade.updateArtist(artist);
    }
}
