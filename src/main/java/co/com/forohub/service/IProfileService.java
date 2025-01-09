package co.com.forohub.service;

import co.com.forohub.dto.profile.CreateProfileRequest;
import co.com.forohub.dto.profile.ProfileRequest;
import co.com.forohub.dto.profile.ProfileResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IProfileService {
    Slice<ProfileResponse> findAll(Pageable pageable);
    ProfileResponse findById(Long id);
    ProfileResponse save(CreateProfileRequest createProfileRequest);
    ProfileResponse update(ProfileRequest profileRequest);
    void delete(Long id);
}
