package by.gorbov.metadata.controller;

import by.gorbov.metadata.dto.GenreDto;
import by.gorbov.metadata.service.api.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/genres")
@RequiredArgsConstructor
@Slf4j
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public List<GenreDto> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public GenreDto getById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody GenreDto genre) {
        genreService.delete(genre);
    }

    @PostMapping
    public void create(@RequestBody GenreDto genre) {
        genreService.save(genre);
    }

    @PutMapping
    public void update(@RequestBody GenreDto genre) {
        genreService.update(genre);
    }
}
