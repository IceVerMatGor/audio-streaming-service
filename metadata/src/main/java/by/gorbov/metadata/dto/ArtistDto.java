package by.gorbov.metadata.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto extends AbstractDto {
    @NotBlank
    private String name;
    private String notes;
    private Long genreId;
    private List<Long> albumsId;
}
