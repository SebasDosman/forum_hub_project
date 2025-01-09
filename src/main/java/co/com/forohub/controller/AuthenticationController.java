package co.com.forohub.controller;

import co.com.forohub.dto.authentication.AuthenticationRequest;
import co.com.forohub.dto.authentication.AuthenticationResponse;
import co.com.forohub.dto.user.CreateUserRequest;
import co.com.forohub.dto.user.UserResponse;
import co.com.forohub.service.IAuthenticationService;
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
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.login(authenticationRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid CreateUserRequest createUserRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.register(createUserRequest), HttpStatus.CREATED);
    }
}