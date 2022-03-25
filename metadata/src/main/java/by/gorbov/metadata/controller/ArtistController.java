package by.gorbov.metadata.controller;

import by.gorbov.metadata.dto.ArtistDto;
import by.gorbov.metadata.service.api.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/artists")
@RequiredArgsConstructor
@Slf4j
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public List<ArtistDto> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public ArtistDto getById(@PathVariable Long id) {
        return artistService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody ArtistDto artist) {
        artistService.delete(artist);
    }

    @PostMapping
    public void create(@RequestBody ArtistDto artist) {
        artistService.save(artist);
    }

    @PutMapping
    public void update(@RequestBody ArtistDto artist) {
        artistService.update(artist);
    }
}
