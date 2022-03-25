package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Genre extends AbstractEntity{
    private String name;
    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;
}
