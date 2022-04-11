package by.gorbov.metadata.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto{
    private Long id;
    private Long storageId;
    private Long songId;
}
