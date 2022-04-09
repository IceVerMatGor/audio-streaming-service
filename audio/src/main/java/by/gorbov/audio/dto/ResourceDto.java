package by.gorbov.audio.dto;

import lombok.*;


import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {
    private Long id;
    private String path;
    private String checksum;
    private String originalFileName;
    private Long storageId;
    private Long songId;
    private UUID audioId;
    private  Long size;
    private  String audioType;
}
