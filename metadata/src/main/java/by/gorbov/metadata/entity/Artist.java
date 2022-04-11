package by.gorbov.metadata.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "name")
        })
public class Artist extends AbstractEntity {

    private String name;
    private String notes;
    @ManyToOne
    private Genre genre;
    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums;

    public void addAlbum(Album album) {
        this.albums.add(album);
        album.getArtists().add(this);
    }

    public void removeArtist(Album album) {
        this.albums.remove(album);
        album.getArtists().remove(this);
    }
}
