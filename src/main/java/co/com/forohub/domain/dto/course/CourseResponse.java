package co.com.forohub.domain.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
}
