package co.com.forohub.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ProfileResponse {
    private String name;
}
