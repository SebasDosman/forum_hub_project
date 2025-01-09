package co.com.forohub.dto.topic;

import co.com.forohub.dto.answer.AnswerResponse;
import co.com.forohub.dto.course.CourseResponse;
import co.com.forohub.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class TopicResponse {
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean status;
    private UserResponse author;
    private CourseResponse course;
    private List<AnswerResponse> answers;
}
