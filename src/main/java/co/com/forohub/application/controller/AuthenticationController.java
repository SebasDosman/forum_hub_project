package co.com.forohub.application.controller;

import co.com.forohub.domain.dto.authentication.AuthenticationRequest;
import co.com.forohub.domain.dto.authentication.AuthenticationResponse;
import co.com.forohub.domain.dto.user.CreateUserRequest;
import co.com.forohub.domain.dto.user.UserResponse;
import co.com.forohub.application.service.IAuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
@Tag(name = "Authentication", description = "Endpoints for user authentication and registration")
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @Operation(summary = "User Login", description = "Authenticates a user using their credentials and returns a JWT token.")
    @PostMapping("/signIn")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody @Valid AuthenticationRequest authenticationRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.signIn(authenticationRequest), HttpStatus.OK);
    }

    @Operation(summary = "User Registration", description = "Registers a new user and returns the created user information.")
    @PostMapping("/signUp")
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid CreateUserRequest createUserRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.signUp(createUserRequest), HttpStatus.CREATED);
    }
}
