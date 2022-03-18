package by.gorbov.demotest.controller;

import by.gorbov.demotest.dto.GenreDto;
import by.gorbov.demotest.dto.ResourceDto;
import by.gorbov.demotest.service.facade.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/genres")
public class GenreController {
    private final Facade facade;

    public GenreController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<GenreDto> getAll() {
        return facade.getAllGenre();
    }

    @GetMapping("/{id}")
    public GenreDto getById(@PathVariable Long id) {
        return facade.getByIdGenre(id);
    }

    @DeleteMapping
    public void delete(@RequestBody GenreDto genre) {
        facade.deleteGenre(genre);
    }

    @PostMapping
    public void create(@RequestBody GenreDto genre) {
        facade.saveGenre(genre);
    }

    @PutMapping
    public void update(@RequestBody GenreDto genre) {
        facade.updateGenre(genre);
    }
}
