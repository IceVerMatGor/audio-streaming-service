package by.gorbov.metadata.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto extends AbstractDto{
    private String type;
    private List<Long> resourcesId;
}
