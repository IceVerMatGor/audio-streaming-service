package by.gorbov.metadata.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto extends AbstractDto{
    private String name;
    private List<Long> artistsId;


}
