package co.com.forohub.domain.dto.user;

import co.com.forohub.domain.validators.UserValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CreateUserRequest {
    @NotBlank(message = UserValidator.NAME_NOT_BLANK)
    @Pattern(regexp = UserValidator.NAME_REGEX, message = UserValidator.NAME_PATTERN)
    @Size(min = 1, max = 255, message = UserValidator.NAME_SIZE)
    private String name;

    @Email(message = UserValidator.EMAIL_PATTERN)
    @NotBlank(message = UserValidator.EMAIL_NOT_BLANK)
    @Size(min = 1, max = 255, message = UserValidator.EMAIL_SIZE)
    private String email;

    @NotBlank(message = UserValidator.PASSWORD_NOT_BLANK)
    @Pattern(regexp = UserValidator.PASSWORD_REGEX, message = UserValidator.PASSWORD_PATTERN)
    @Size(min = 1, max = 255, message = UserValidator.PASSWORD_SIZE)
    private String password;

    @NotNull(message = UserValidator.PROFILES_IDS_NOT_NULL)
    private Long[] profileIds;
}
