package co.com.forohub.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CourseResponse {
    private String name;
    private String description;
}
