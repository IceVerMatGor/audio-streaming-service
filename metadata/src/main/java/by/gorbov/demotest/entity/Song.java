package by.gorbov.demotest.entity;

import javax.persistence.*;

@Entity
public class Song extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Resource resource;
    private String notes;
    private Integer year;
    private String name;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
