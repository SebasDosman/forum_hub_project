package co.com.forohub.application.service;

import co.com.forohub.domain.dto.profile.CreateProfileRequest;
import co.com.forohub.domain.dto.profile.ProfileRequest;
import co.com.forohub.domain.dto.profile.ProfileResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IProfileService {
    Slice<ProfileResponse> findAll(Pageable pageable);
    ProfileResponse findById(Long id);
    ProfileResponse save(CreateProfileRequest createProfileRequest);
    ProfileResponse update(ProfileRequest profileRequest);
    void delete(Long id);
}
