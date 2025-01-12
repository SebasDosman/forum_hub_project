package co.com.forohub.domain.dto.user;

import co.com.forohub.domain.validators.UserValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class UserRequest {
    @Min(value = 1, message = UserValidator.ID_POSITIVE)
    @NotNull(message = UserValidator.ID_NOT_NULL)
    private Long id;

    @NotBlank(message = UserValidator.NAME_NOT_BLANK)
    @Pattern(regexp = UserValidator.NAME_REGEX, message = UserValidator.NAME_PATTERN)
    @Size(min = 1, max = 255, message = UserValidator.NAME_SIZE)
    private String name;

    @NotBlank(message = UserValidator.PASSWORD_NOT_BLANK)
    @Pattern(regexp = UserValidator.PASSWORD_REGEX, message = UserValidator.PASSWORD_PATTERN)
    @Size(min = 1, max = 255, message = UserValidator.PASSWORD_SIZE)
    private String password;
}
