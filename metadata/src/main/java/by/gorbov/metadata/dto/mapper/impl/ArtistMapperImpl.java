package by.gorbov.metadata.dto.mapper.impl;

import by.gorbov.metadata.dto.ArtistDto;
import by.gorbov.metadata.dto.mapper.api.ArtistMapper;
import by.gorbov.metadata.entity.AbstractEntity;
import by.gorbov.metadata.entity.Artist;
import by.gorbov.metadata.entity.Genre;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ArtistMapperImpl extends AbstractMapper<ArtistDto, Artist> implements ArtistMapper {
    @Override
    protected Class<Artist> getEntityClass() {
        return Artist.class;
    }

    @Override
    protected Class<ArtistDto> getDtoClass() {
        return ArtistDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Artist.class, ArtistDto.class)
                .addMappings(m -> m.skip(ArtistDto::setAlbumsId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(ArtistDto::setGenreId)).setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(Artist source, ArtistDto destination) {
        List<Long> albumsId = source.getAlbums().stream().mapToLong(AbstractEntity::getId).boxed().toList();
        destination.setAlbumsId(albumsId);

        if (source.getGenre()!=null)
        destination.setGenreId(source.getGenre().getId());
    }

    @Override
    public void mapSpecificFields(ArtistDto source, Artist destination){
        Genre genre = new Genre();
        genre.setId(source.getGenreId());
        destination.setGenre(genre);
    }
}
