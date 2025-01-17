package co.com.forohub.domain.dto.authentication;

import co.com.forohub.domain.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
    private Long expiresIn;
}
