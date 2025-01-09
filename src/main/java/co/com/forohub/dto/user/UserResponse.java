package co.com.forohub.dto.user;

import co.com.forohub.dto.profile.ProfileResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class UserResponse {
    private String name;
    private String email;
    private List<ProfileResponse> profiles;
}
