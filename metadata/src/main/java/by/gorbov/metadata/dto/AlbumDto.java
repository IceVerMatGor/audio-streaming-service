package by.gorbov.metadata.dto;

import lombok.*;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.PastValidatorForYear;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto extends AbstractDto {
    @NotBlank
    private String name;

    @PastOrPresent
    private Year year;

    private String notes;

    @NotEmpty
    private List<SongDto> songs;
    private List<Long> artistsId;
}
