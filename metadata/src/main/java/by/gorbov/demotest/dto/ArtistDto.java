package by.gorbov.demotest.dto;

import java.util.List;

public class ArtistDto extends AbstractDto{
    private String name;
    private String notes;
    private Long genreId;
    private List<Long> albumsId;

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public List<Long> getAlbumsId() {
        return albumsId;
    }

    public void setAlbumsId(List<Long> albumsId) {
        this.albumsId = albumsId;
    }

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
}
