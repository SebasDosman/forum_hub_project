package co.com.forohub.service.implementation;

import co.com.forohub.domain.User;
import co.com.forohub.dto.authentication.AuthenticationRequest;
import co.com.forohub.dto.authentication.AuthenticationResponse;
import co.com.forohub.dto.user.CreateUserRequest;
import co.com.forohub.dto.user.UserResponse;
import co.com.forohub.exceptions.ConflictException;
import co.com.forohub.exceptions.NotFoundException;
import co.com.forohub.mappers.UserMapper;
import co.com.forohub.repository.ProfileRepository;
import co.com.forohub.repository.UserRepository;
import co.com.forohub.service.IAuthenticationService;
import co.com.forohub.service.ITokenService;
import co.com.forohub.utils.validators.ProfileValidator;
import co.com.forohub.utils.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class AuthenticationService implements IAuthenticationService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final ITokenService tokenService;

    @Override
    @Transactional
    public AuthenticationResponse signIn(AuthenticationRequest authenticationRequest) throws Exception {
        if (!userRepository.existsByEmail(authenticationRequest.getEmail())) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, authenticationRequest.getEmail()));

        User user = userRepository.findByEmail(authenticationRequest.getEmail());

        return createAuthenticationResponse(createJwtToken(authenticationRequest), user);
    }

    @Override
    @Transactional
    public UserResponse signUp(CreateUserRequest createUserRequest) {
        validateCreateUserRequest(createUserRequest);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = UserMapper.toUser(createUserRequest, bCryptPasswordEncoder.encode(createUserRequest.getPassword()), profileRepository.findAllById(Arrays.stream(createUserRequest.getProfileIds()).toList()));

        return UserMapper.toUserResponse(userRepository.save(user));
    }

    private String createJwtToken(AuthenticationRequest authenticationRequest) throws Exception {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),
                authenticationRequest.getPassword()
        );

        Authentication authenticatedPerson = authenticationManager.authenticate(authToken);
        User user = (User) customUserDetailsService.loadUserByUsername(authenticatedPerson.getName());

        return tokenService.generateToken(user);
    }

    private AuthenticationResponse createAuthenticationResponse(String token, User user) throws Exception {
        return AuthenticationResponse.builder()
                .user(UserMapper.toUserResponse(user))
                .token(token)
                .expiresIn(tokenService.getExpirationTime(token))
                .build();
    }

    private void validateCreateUserRequest(CreateUserRequest createUserRequest) {
        if (userRepository.existsByEmail(createUserRequest.getEmail())) throw new ConflictException(String.format(UserValidator.EMAIL_ALREADY_EXISTS, createUserRequest.getEmail()));
        if (createUserRequest.getProfileIds() != null) {
            for (Long profileId: createUserRequest.getProfileIds()) {
                if (!profileRepository.existsById(profileId)) throw new NotFoundException(String.format(ProfileValidator.PROFILE_NOT_FOUND, profileId));
            }
        }
    }
}
