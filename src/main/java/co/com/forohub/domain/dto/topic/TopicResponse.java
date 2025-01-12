package co.com.forohub.domain.dto.topic;

import co.com.forohub.domain.dto.answer.AnswerResponse;
import co.com.forohub.domain.dto.course.CourseResponse;
import co.com.forohub.domain.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class TopicResponse {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean status;
    private UserResponse author;
    private CourseResponse course;
    private List<AnswerResponse> answers;
}
