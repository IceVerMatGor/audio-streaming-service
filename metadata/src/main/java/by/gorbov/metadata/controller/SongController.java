package by.gorbov.metadata.controller;

import by.gorbov.metadata.dto.SongDto;
import by.gorbov.metadata.service.api.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/songs")
@RequiredArgsConstructor
@Slf4j
public class SongController {
    private final SongService songService;

    @GetMapping
    public List<SongDto> getAll() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public SongDto getById(@PathVariable Long id) {
        return songService.getById(id);
    }


}
