package co.com.forohub.dto.answer;

import co.com.forohub.utils.validators.AnswerValidator;
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
public class CreateAnswerRequest {
    @NotBlank(message = AnswerValidator.MESSAGE_NOT_BLANK)
    @Size(min = 1, max = 500, message = AnswerValidator.MESSAGE_SIZE)
    private String message;

    @NotNull(message = AnswerValidator.TOPIC_ID_NOT_NULL)
    @Min(value = 1, message = AnswerValidator.TOPIC_ID_POSITIVE)
    private Long topicId;

    @NotNull(message = AnswerValidator.AUTHOR_ID_NOT_NULL)
    @Min(value = 1, message = AnswerValidator.AUTHOR_ID_POSITIVE)
    private Long authorId;

    @NotBlank(message = AnswerValidator.SOLUTION_NOT_BLANK)
    @Size(min = 1, max = 500, message = AnswerValidator.SOLUTION_SIZE)
    private String solution;
}
