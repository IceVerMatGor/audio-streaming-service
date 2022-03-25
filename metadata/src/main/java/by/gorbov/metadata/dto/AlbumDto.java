package by.gorbov.metadata.dto;

import java.util.List;

public class AlbumDto extends AbstractDto{
    private String name;
    private Integer year;
    private String notes;
    private List<Long> songsId;
    private List<Long> artistsId;

    public List<Long> getSongsId() {
        return songsId;
    }

    public void setSongsId(List<Long> songsId) {
        this.songsId = songsId;
    }

    public List<Long> getArtistsId() {
        return artistsId;
    }

    public void setArtistsId(List<Long> artistsId) {
        this.artistsId = artistsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
