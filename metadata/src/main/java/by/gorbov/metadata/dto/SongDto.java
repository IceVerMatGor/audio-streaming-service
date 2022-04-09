package by.gorbov.metadata.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.Year;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDto extends AbstractDto{
    private String notes;
    private Year year;
    @NotBlank
    private String name;
    private Long albumId;
    private Long resourceId;
}
