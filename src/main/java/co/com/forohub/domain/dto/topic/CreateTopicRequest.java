package co.com.forohub.domain.dto.topic;

import co.com.forohub.domain.validators.TopicValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CreateTopicRequest {
    @NotBlank(message = TopicValidator.TITLE_NOT_BLANK)
    @Size(min = 1, max = 255, message = TopicValidator.TITLE_SIZE)
    private String title;

    @NotBlank(message = TopicValidator.MESSAGE_NOT_BLANK)
    @Size(min = 1, max = 500, message = TopicValidator.MESSAGE_SIZE)
    private String message;

    @NotNull(message = TopicValidator.AUTHOR_ID_NOT_NULL)
    private Long authorId;

    @NotNull(message = TopicValidator.COURSE_ID_NOT_NULL)
    private Long courseId;

    @NotNull(message = TopicValidator.ANSWER_IDS_NOT_NULL)
    private Long[] answerIds;
}
