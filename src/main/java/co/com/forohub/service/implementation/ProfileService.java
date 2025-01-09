package co.com.forohub.service.implementation;

import co.com.forohub.domain.Profile;
import co.com.forohub.dto.profile.CreateProfileRequest;
import co.com.forohub.dto.profile.ProfileRequest;
import co.com.forohub.dto.profile.ProfileResponse;
import co.com.forohub.exceptions.NotFoundException;
import co.com.forohub.mappers.ProfileMapper;
import co.com.forohub.repository.ProfileRepository;
import co.com.forohub.service.IProfileService;
import co.com.forohub.utils.validators.ProfileValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProfileService implements IProfileService {
    private final ProfileRepository profileRepository;

    @Override
    @Transactional(readOnly = true)
    public Slice<ProfileResponse> findAll(Pageable pageable) {
        return ProfileMapper.toProfileResponseSlice(profileRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public ProfileResponse findById(Long id) {
        if (!profileRepository.existsById(id)) throw new NotFoundException(String.format(ProfileValidator.PROFILE_NOT_FOUND, id));

        return ProfileMapper.toProfileResponse(profileRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public ProfileResponse save(CreateProfileRequest createProfileRequest) {
        Profile profile = ProfileMapper.toProfile(createProfileRequest);

        return ProfileMapper.toProfileResponse(profileRepository.save(profile));
    }

    @Override
    @Transactional
    public ProfileResponse update(ProfileRequest profileRequest) {
        Profile profile = ProfileMapper.toProfile(profileRequest);

        return ProfileMapper.toProfileResponse(profileRepository.save(profile));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!profileRepository.existsById(id)) throw new NotFoundException(String.format(ProfileValidator.PROFILE_NOT_FOUND, id));

        profileRepository.deleteById(id);
    }
}
