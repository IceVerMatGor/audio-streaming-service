package by.gorbov.demotest.controller;

import by.gorbov.demotest.dto.ResourceDto;
import by.gorbov.demotest.dto.StorageDto;
import by.gorbov.demotest.service.facade.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/resources")
public class ResourceController {
    private final Facade facade;

    public ResourceController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<ResourceDto> getAll() {
        return facade.getAllResource();
    }

    @GetMapping("/{id}")
    public ResourceDto getById(@PathVariable Long id) {
        return facade.getByIdResource(id);
    }

    @DeleteMapping
    public void delete(@RequestBody ResourceDto resource) {
        facade.deleteResource(resource);
    }

    @PostMapping
    public void create(@RequestBody ResourceDto resource) {
        facade.saveResource(resource);
    }

    @PutMapping
    public void update(@RequestBody ResourceDto resource) {
        facade.updateResource(resource);
    }
}
