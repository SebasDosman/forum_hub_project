package co.com.forohub.domain.mappers;

import co.com.forohub.domain.entities.Profile;
import co.com.forohub.domain.dto.profile.CreateProfileRequest;
import co.com.forohub.domain.dto.profile.ProfileRequest;
import co.com.forohub.domain.dto.profile.ProfileResponse;
import org.springframework.data.domain.Slice;

import java.util.List;

public class ProfileMapper {
    public static ProfileResponse toProfileResponse(Profile profile) {
        return ProfileResponse.builder()
                .id(profile.getId())
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

    public static List<ProfileResponse> toProfileResponseList(List<Profile> profiles) {
        return profiles.stream().map(ProfileMapper::toProfileResponse).toList();
    }
}
