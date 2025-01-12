package co.com.forohub.domain.dto.course;

import co.com.forohub.domain.validators.CourseValidator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CourseRequest {
    @Min(value = 1, message = CourseValidator.ID_POSITIVE)
    @NotNull(message = CourseValidator.ID_NOT_NULL)
    private Long id;

    @NotBlank(message = CourseValidator.NAME_NOT_BLANK)
    @Size(min = 1, max = 255, message = CourseValidator.NAME_SIZE)
    private String name;

    @NotBlank(message = CourseValidator.DESCRIPTION_NOT_BLANK)
    @Size(min = 1, max = 500, message = CourseValidator.DESCRIPTION_SIZE)
    private String description;
}
