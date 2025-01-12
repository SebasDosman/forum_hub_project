package co.com.forohub.domain.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ProfileResponse {
    private Long id;
    private String name;
}
