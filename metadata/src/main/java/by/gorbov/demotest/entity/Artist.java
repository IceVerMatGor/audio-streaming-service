package by.gorbov.demotest.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Artist extends AbstractEntity{
    private String name;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;
    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
        album.getArtists().add(this);
    }

    public void removeArtist(Album album) {
        this.albums.remove(album);
        album.getArtists().remove(this);
    }
}
