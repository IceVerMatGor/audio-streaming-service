package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Song extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Resource resource;
    private String notes;
    private Integer year;
    private String name;
}
