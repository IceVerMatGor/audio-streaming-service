package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Year;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = {"name","album_id"})
        })
public class Song extends AbstractEntity {

    @ManyToOne
    private Album album;

    private Long resourceId;

    private String notes;
    private Year year;
    private String name;
}
