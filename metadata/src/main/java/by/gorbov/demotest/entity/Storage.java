package by.gorbov.demotest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Storage extends AbstractEntity {
    private String type;

    @OneToMany(mappedBy = "storage",cascade = CascadeType.REMOVE)
    private List<Resource> resources;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
