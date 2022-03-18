package by.gorbov.demotest.dto;

import java.util.List;

public class GenreDto extends AbstractDto{
    private String name;
    private List<Long> artistsId;

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
}
