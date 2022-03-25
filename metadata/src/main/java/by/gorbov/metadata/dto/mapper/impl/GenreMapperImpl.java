package by.gorbov.metadata.dto.mapper.impl;

import by.gorbov.metadata.dto.GenreDto;
import by.gorbov.metadata.dto.mapper.api.GenreMapper;
import by.gorbov.metadata.entity.AbstractEntity;
import by.gorbov.metadata.entity.Genre;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class GenreMapperImpl extends AbstractMapper<GenreDto, Genre> implements GenreMapper {
    @Override
    protected Class<Genre> getEntityClass() {
        return Genre.class;
    }

    @Override
    protected Class<GenreDto> getDtoClass() {
        return GenreDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Genre.class, GenreDto.class)
                .addMappings(m -> m.skip(GenreDto::setArtistsId)).setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(Genre source, GenreDto destination) {
        List<Long> artistsId = source.getArtists().stream().mapToLong(AbstractEntity::getId).boxed().toList();

        destination.setArtistsId(artistsId);
    }
}
