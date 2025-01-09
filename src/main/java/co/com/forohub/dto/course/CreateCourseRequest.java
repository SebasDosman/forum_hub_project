package co.com.forohub.dto.course;

import co.com.forohub.utils.validators.CourseValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CreateCourseRequest {
    @NotBlank(message = CourseValidator.NAME_NOT_BLANK)
    @Size(min = 1, max = 255, message = CourseValidator.NAME_SIZE)
    private String name;

    @NotBlank(message = CourseValidator.DESCRIPTION_NOT_BLANK)
    @Size(min = 1, max = 500, message = CourseValidator.DESCRIPTION_SIZE)
    private String description;
}
