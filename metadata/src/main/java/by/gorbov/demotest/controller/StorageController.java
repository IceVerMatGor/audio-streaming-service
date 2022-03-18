package by.gorbov.demotest.controller;

import by.gorbov.demotest.dto.SongDto;
import by.gorbov.demotest.dto.StorageDto;
import by.gorbov.demotest.service.facade.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/storages")
public class StorageController {
    private final Facade facade;

    public StorageController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<StorageDto> getAll() {
        return facade.getAllStorage();
    }

    @GetMapping("/{id}")
    public StorageDto getById(@PathVariable Long id) {
        return facade.getByIdStorage(id);
    }

    @DeleteMapping
    public void delete(@RequestBody StorageDto storage) {
        facade.deleteStorage(storage);
    }

    @PostMapping
    public void create(@RequestBody StorageDto storage) {
        facade.saveStorage(storage);
    }

    @PutMapping
    public void update(@RequestBody StorageDto storage) {
        facade.updateStorage(storage);
    }
}
