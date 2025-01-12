package co.com.forohub.application.controller;

import co.com.forohub.domain.dto.user.UserRequest;
import co.com.forohub.domain.dto.user.UserResponse;
import co.com.forohub.application.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Users", description = "Endpoints for managing users")
@SecurityRequirement(name = "bearer-key")
public class UserController {
    private final IUserService userService;

    @Operation(summary = "Get all users", description = "Retrieves a paginated list of all users.")
    @GetMapping()
    public ResponseEntity<Slice<UserResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get user by ID", description = "Retrieves a user by their unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update user", description = "Updates an existing user's information.")
    @PutMapping()
    public ResponseEntity<UserResponse> update(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(userService.update(userRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete user", description = "Deletes a user by their unique ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
