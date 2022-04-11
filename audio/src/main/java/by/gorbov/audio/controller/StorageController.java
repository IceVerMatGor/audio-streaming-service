package by.gorbov.audio.controller;

import by.gorbov.audio.dto.StorageDto;
import by.gorbov.audio.entity.Storage;
import by.gorbov.audio.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/storages")
@Slf4j
@AllArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @GetMapping
    public List<StorageDto> getAll() {
        return storageService.getAll();
    }

    @GetMapping("/{id}")
    public StorageDto getById(@PathVariable Long id) {
        return storageService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody StorageDto storage) {
        storageService.save(storage);
    }

    @PutMapping
    public void update(@RequestBody StorageDto storage) {
        storageService.update(storage);
    }
}
