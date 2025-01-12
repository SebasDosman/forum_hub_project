package co.com.forohub.application.service;

import co.com.forohub.domain.dto.authentication.AuthenticationRequest;
import co.com.forohub.domain.dto.authentication.AuthenticationResponse;
import co.com.forohub.domain.dto.user.CreateUserRequest;
import co.com.forohub.domain.dto.user.UserResponse;

public interface IAuthenticationService {
    AuthenticationResponse signIn(AuthenticationRequest authenticationRequest) throws Exception;
    UserResponse signUp(CreateUserRequest createUserRequest) throws Exception;
}
