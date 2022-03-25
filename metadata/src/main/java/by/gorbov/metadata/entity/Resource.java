package by.gorbov.metadata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resource extends AbstractEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    private Storage storage;
    @OneToOne(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private Song song;
    private String path;
    private Integer size;
    private Integer checksum;
}
