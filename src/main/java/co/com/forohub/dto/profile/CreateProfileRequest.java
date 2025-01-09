package co.com.forohub.dto.profile;

import co.com.forohub.utils.validators.ProfileValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CreateProfileRequest {
    @NotBlank(message = ProfileValidator.NAME_NOT_BLANK)
    @Size(min = 1, max = 255, message = ProfileValidator.NAME_SIZE)
    private String name;
}
