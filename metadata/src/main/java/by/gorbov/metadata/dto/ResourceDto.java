package by.gorbov.metadata.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto extends AbstractDto{
    private String path;
    private Integer size;
    private Integer checksum;
    private Long storageId;
    private Long songId;
}
