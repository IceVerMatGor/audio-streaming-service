package by.gorbov.audio.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto{
    private Long id;
    private String type;
    private List<Long> resourcesId;
}
