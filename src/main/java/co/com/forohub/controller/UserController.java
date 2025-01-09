package co.com.forohub.controller;

import co.com.forohub.dto.user.UserRequest;
import co.com.forohub.dto.user.UserResponse;
import co.com.forohub.service.IUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@SecurityRequirement(name = "bearer-key")
public class UserController {
    private final IUserService userService;

    @GetMapping()
    public ResponseEntity<Slice<UserResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> update(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(userService.update(userRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
