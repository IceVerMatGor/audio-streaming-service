package by.gorbov.metadata.dto.mapper.impl;

import by.gorbov.metadata.dto.SongDto;
import by.gorbov.metadata.dto.mapper.api.SongMapper;
import by.gorbov.metadata.entity.Album;
import by.gorbov.metadata.entity.Resource;
import by.gorbov.metadata.entity.Song;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SongMapperImpl extends AbstractMapper<SongDto,Song> implements SongMapper {
    @Override
    protected Class<Song> getEntityClass() {
        return Song.class;
    }

    @Override
    protected Class<SongDto> getDtoClass() {
        return SongDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Song.class, SongDto.class)
                .addMappings(m -> m.skip(SongDto::setAlbumId)).setPostConverter(toDtoConverter());

    }

    @Override
    public void mapSpecificFields(Song source, SongDto destination) {
        if (source.getAlbum() != null)
            destination.setAlbumId(source.getAlbum().getId());

    }
    @Override
    public void mapSpecificFields(SongDto source, Song destination) {
    }
}
