package by.gorbov.demotest.service.impl;

import by.gorbov.demotest.dto.ResourceDto;
import by.gorbov.demotest.dto.mapper.api.Mapper;
import by.gorbov.demotest.dto.mapper.api.ResourceMapper;
import by.gorbov.demotest.entity.Resource;
import by.gorbov.demotest.repo.ResourceRepository;
import by.gorbov.demotest.service.api.ResourceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl extends AbstractService<ResourceDto,Resource> implements ResourceService {

    public ResourceServiceImpl(JpaRepository<Resource, Long> repository, ResourceMapper mapper) {
        super(repository, mapper);
    }
}
