package by.gorbov.metadata.controller;

import by.gorbov.metadata.dto.StorageDto;
import by.gorbov.metadata.service.api.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/storages")
@RequiredArgsConstructor
@Slf4j
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
