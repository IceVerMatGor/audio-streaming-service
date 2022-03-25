package by.gorbov.metadata.controller;

import by.gorbov.metadata.dto.ResourceDto;
import by.gorbov.metadata.service.api.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/resources")
@RequiredArgsConstructor
@Slf4j
public class ResourceController {
    private final ResourceService resourceService;


    @GetMapping
    public List<ResourceDto> getAll() {
        return resourceService.getAll();
    }

    @GetMapping("/{id}")
    public ResourceDto getById(@PathVariable Long id) {
        return resourceService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody ResourceDto resource) {
        resourceService.delete(resource);
    }

    @PostMapping
    public void create(@RequestBody ResourceDto resource) {
        resourceService.save(resource);
    }

    @PutMapping
    public void update(@RequestBody ResourceDto resource) {
        resourceService.update(resource);
    }
}
