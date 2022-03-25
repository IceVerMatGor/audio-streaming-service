package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album extends AbstractEntity{
    private String name;
    private Integer year;
    private String notes;
    @ManyToMany()
    private Set<Artist> artists;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<Song> songs;

    public void addArtist(Artist artist) {
        this.artists.add(artist);
        artist.getAlbums().add(this);
    }

    public void removeArtist(Artist artist) {
        this.artists.remove(artist);
        artist.getAlbums().remove(this);
    }
}
