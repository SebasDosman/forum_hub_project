package co.com.forohub.service;

import co.com.forohub.dto.authentication.AuthenticationRequest;
import co.com.forohub.dto.authentication.AuthenticationResponse;
import co.com.forohub.dto.user.CreateUserRequest;
import co.com.forohub.dto.user.UserResponse;

public interface IAuthenticationService {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws Exception;
    UserResponse register(CreateUserRequest createUserRequest) throws Exception;
}
