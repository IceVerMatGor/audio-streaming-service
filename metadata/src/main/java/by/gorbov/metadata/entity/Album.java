package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
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
                @UniqueConstraint(columnNames = {"name", "year"})
        })
public class Album extends AbstractEntity {


    private String name;
    private Year year;
    private String notes;
    @ManyToMany
    private Set<Artist> artists;

    @OneToMany(
            mappedBy = "album",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Song> songs = new ArrayList<>();

    public void addArtist(Artist artist) {
        this.artists.add(artist);
        artist.getAlbums().add(this);
    }

    public void removeArtist(Artist artist) {
        this.artists.remove(artist);
        artist.getAlbums().remove(this);
    }
}
