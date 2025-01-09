package co.com.forohub.dto.authentication;

import co.com.forohub.dto.user.UserResponse;
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
