package by.gorbov.audio.service;

import by.gorbov.audio.dto.ResourceDto;
import by.gorbov.audio.dto.mapper.ResourceMapper;
import by.gorbov.audio.entity.Resource;
import by.gorbov.audio.repo.AudioStore;
import by.gorbov.audio.repo.ResourceRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService{

    private final ResourceRepo resourceRepo;
    private final AudioStore audioStore;
    private final ResourceMapper resourceMapper;

    @Override
    public ResourceDto getById(Long id) {
        if (resourceRepo.findById(id).isPresent()) {
            return resourceMapper.toDto(resourceRepo.findById(id).get());
        }
        return null;
    }

    @Override
    public List<ResourceDto> getAll() {
        List<ResourceDto> resourceDtos = new ArrayList<>();
        resourceRepo.findAll().forEach(resource -> resourceDtos.add(resourceMapper.toDto(resource)));
        return resourceDtos;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {SQLException.class, NullPointerException.class})
    public void deleteAllById(List<Long> ids) {
        List<Resource> resources = resourceRepo.findAllById(ids);
        resources.forEach(audioStore::unsetContent);
        resourceRepo.deleteAllById(ids);
    }

    @Override
    public void saveAll(List<ResourceDto> resourceDtos) {
        List<Resource> resources = new ArrayList<>();
        resourceDtos.forEach(resourceDto -> resources.add(resourceMapper.toEntity(resourceDto)));
        resourceRepo.saveAll(resources);
    }

    @Override
    public void update(ResourceDto resourceDto) {
        resourceRepo.save(resourceMapper.toEntity(resourceDto));
    }
}
