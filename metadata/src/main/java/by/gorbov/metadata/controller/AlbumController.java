package by.gorbov.metadata.controller;

import by.gorbov.metadata.dto.AlbumDto;
import by.gorbov.metadata.service.api.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/albums")
@RequiredArgsConstructor
@Slf4j
public class AlbumController {
    private final AlbumService albumService;



    @GetMapping
    public List<AlbumDto> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public AlbumDto getById(@PathVariable Long id) {
        return albumService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody AlbumDto album) {
        albumService.delete(album);
    }

    @PostMapping
    public void create(@RequestBody AlbumDto album) {
        albumService.save(album);
    }

    @PutMapping
    public void update(@RequestBody AlbumDto album) {
        albumService.update(album);
    }
}
