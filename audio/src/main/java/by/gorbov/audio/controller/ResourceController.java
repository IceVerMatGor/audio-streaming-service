package by.gorbov.audio.controller;

import by.gorbov.audio.dto.ResourceDto;
import by.gorbov.audio.entity.Resource;
import by.gorbov.audio.repo.AudioStore;
import by.gorbov.audio.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/resources")
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
    public void delete(@RequestBody List<Long> ids) {
        resourceService.deleteAllById(ids);
    }

    @PostMapping
    public void create(@RequestBody List<ResourceDto> resources) {
        resourceService.saveAll(resources);
    }



}
