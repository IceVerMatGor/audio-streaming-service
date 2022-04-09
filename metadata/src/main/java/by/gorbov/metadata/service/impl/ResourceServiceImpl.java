package by.gorbov.metadata.service.impl;

import by.gorbov.metadata.dto.ResourceDto;
import by.gorbov.metadata.dto.mapper.api.ResourceMapper;
import by.gorbov.metadata.entity.Resource;
import by.gorbov.metadata.service.api.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResourceServiceImpl implements ResourceService {


    @Override
    public List<ResourceDto> getAll() {
        return null;
    }

    @Override
    public ResourceDto getById(Long id) {
        return null;
    }

    @Override
    public void save(ResourceDto resourceDto) {

    }

    @Override
    public void update(ResourceDto resourceDto) {

    }

    @Override
    public void deleteAllById(List<Long> ids) {

    }
}
