package by.gorbov.audio.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "storage")
    private List<Resource> resources;
}
