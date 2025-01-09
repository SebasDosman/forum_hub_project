package co.com.forohub.mappers;

import co.com.forohub.domain.Profile;
import co.com.forohub.dto.profile.CreateProfileRequest;
import co.com.forohub.dto.profile.ProfileRequest;
import co.com.forohub.dto.profile.ProfileResponse;
import org.springframework.data.domain.Slice;

public class ProfileMapper {
    public static ProfileResponse toProfileResponse(Profile profile) {
        return ProfileResponse.builder()
                .name(profile.getName())
                .build();
    }

    public static Profile toProfile(CreateProfileRequest createProfileRequest) {
        return Profile.builder()
                .name(createProfileRequest.getName())
                .build();
    }

    public static Profile toProfile(ProfileRequest profileRequest) {
        return Profile.builder()
                .id(profileRequest.getId())
                .name(profileRequest.getName())
                .build();
    }

    public static Slice<ProfileResponse> toProfileResponseSlice(Slice<Profile> profiles) {
        return profiles.map(ProfileMapper::toProfileResponse);
    }
}
