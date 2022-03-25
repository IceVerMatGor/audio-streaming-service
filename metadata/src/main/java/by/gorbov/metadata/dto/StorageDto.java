package by.gorbov.metadata.dto;

import java.util.List;

public class StorageDto extends AbstractDto{
    private String type;
    private List<Long> resourcesId;

    public List<Long> getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(List<Long> resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
