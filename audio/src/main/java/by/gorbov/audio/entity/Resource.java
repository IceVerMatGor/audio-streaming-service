package by.gorbov.audio.entity;

import lombok.*;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resource {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Storage storage;
    private Long songId;
    private String path;
    private String originalFileName;

    private String checksum;

    @ContentId
    private UUID audioId;

    @ContentLength
    private  Long size;

    @MimeType
    private  String audioType;
}
