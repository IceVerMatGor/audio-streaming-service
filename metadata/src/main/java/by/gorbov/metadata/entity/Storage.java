package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Storage extends AbstractEntity {
    private String type;

    @OneToMany(mappedBy = "storage",cascade = CascadeType.REMOVE)
    private List<Resource> resources;
}
