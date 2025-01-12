package co.com.forohub.domain.dto.answer;

import co.com.forohub.domain.dto.user.UserResponse;
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
