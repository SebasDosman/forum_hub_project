package co.com.forohub.dto.answer;

import co.com.forohub.dto.topic.TopicResponse;
import co.com.forohub.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class AnswerResponse {
    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private UserResponse author;
    private String solution;
}
