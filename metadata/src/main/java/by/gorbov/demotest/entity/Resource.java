package by.gorbov.demotest.entity;

import javax.persistence.*;

@Entity
public class Resource extends AbstractEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    private Storage storage;
    @OneToOne(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private Song song;
    private String path;
    private Integer size;
    private Integer checksum;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getChecksum() {
        return checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }
}
