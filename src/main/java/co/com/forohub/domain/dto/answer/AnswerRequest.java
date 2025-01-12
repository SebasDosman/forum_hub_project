package co.com.forohub.domain.dto.answer;

import co.com.forohub.domain.validators.AnswerValidator;
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
public class AnswerRequest {
    @Min(value = 1, message = AnswerValidator.ID_POSITIVE)
    @NotNull(message = AnswerValidator.ID_NOT_NULL)
    private Long id;

    @NotBlank(message = AnswerValidator.MESSAGE_NOT_BLANK)
    @Size(min = 1, max = 500, message = AnswerValidator.MESSAGE_SIZE)
    private String message;

    @NotBlank(message = AnswerValidator.SOLUTION_NOT_BLANK)
    @Size(min = 1, max = 500, message = AnswerValidator.SOLUTION_SIZE)
    private String solution;
}
