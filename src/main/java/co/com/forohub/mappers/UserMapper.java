package co.com.forohub.mappers;

import co.com.forohub.domain.Profile;
import co.com.forohub.domain.User;
import co.com.forohub.dto.user.CreateUserRequest;
import co.com.forohub.dto.user.UserRequest;
import co.com.forohub.dto.user.UserResponse;
import org.springframework.data.domain.Slice;

import java.util.List;

public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .profiles(ProfileMapper.toProfileResponseList(user.getProfiles()))
                .build();
    }

    public static User toUser(CreateUserRequest createUserRequest, String password, List<Profile> profiles) {
        return User.builder()
                .name(createUserRequest.getName())
                .email(createUserRequest.getEmail())
                .password(password)
                .profiles(profiles)
                .build();
    }

    public static User toUser(UserRequest userRequest, String password, List<Profile> profiles) {
        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .password(password)
                .profiles(profiles)
                .build();
    }

    public static Slice<UserResponse> toUserResponseSlice(Slice<User> users) {
        return users.map(UserMapper::toUserResponse);
    }
}
