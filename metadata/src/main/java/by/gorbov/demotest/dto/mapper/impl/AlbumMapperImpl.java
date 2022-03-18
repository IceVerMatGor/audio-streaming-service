package by.gorbov.demotest.dto.mapper.impl;

import by.gorbov.demotest.dto.AlbumDto;
import by.gorbov.demotest.dto.mapper.api.AlbumMapper;
import by.gorbov.demotest.entity.AbstractEntity;
import by.gorbov.demotest.entity.Album;
import by.gorbov.demotest.entity.Artist;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class AlbumMapperImpl extends AbstractMapper<AlbumDto, Album> implements AlbumMapper {
    @Override
    protected Class<Album> getEntityClass() {
        return Album.class;
    }

    @Override
    protected Class<AlbumDto> getDtoClass() {
        return AlbumDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Album.class, AlbumDto.class)
                .addMappings(m -> m.skip(AlbumDto::setArtistsId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(AlbumDto::setSongsId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(AlbumDto.class, Album.class)
                .addMappings(m -> m.skip(Album::setArtists)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Album source, AlbumDto destination) {
        List<Long> artistsId = source.getArtists().stream().mapToLong(AbstractEntity::getId).boxed().toList();
        List<Long> songsId = source.getSongs().stream().mapToLong(AbstractEntity::getId).boxed().toList();

        destination.setArtistsId(artistsId);
        destination.setSongsId(songsId);
    }

    @Override
    public void mapSpecificFields(AlbumDto source,Album destination){
        List<Long> artistsId = source.getArtistsId();
        destination.setArtists(new HashSet<>());
        artistsId.forEach((id)-> {
            Artist artist = new Artist();
            artist.setId(id);
            artist.setAlbums(new HashSet<>());
            artist.addAlbum(destination);
        });
    }




}
