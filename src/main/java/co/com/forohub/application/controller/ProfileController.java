package co.com.forohub.application.controller;

import co.com.forohub.domain.dto.profile.CreateProfileRequest;
import co.com.forohub.domain.dto.profile.ProfileRequest;
import co.com.forohub.domain.dto.profile.ProfileResponse;
import co.com.forohub.application.service.IProfileService;
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
@RequestMapping("/profiles")
@RestController
@Tag(name = "Profiles", description = "Endpoints for managing user profiles")
@SecurityRequirement(name = "bearer-key")
public class ProfileController {
    private final IProfileService profileService;

    @Operation(summary = "Get all profiles", description = "Retrieves a paginated list of all user profiles.")
    @GetMapping()
    public ResponseEntity<Slice<ProfileResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(profileService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get profile by ID", description = "Retrieves a single profile by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new profile", description = "Creates a new user profile and returns the created object.")
    @PostMapping()
    public ResponseEntity<ProfileResponse> save(@RequestBody @Valid CreateProfileRequest createProfileRequest) {
        return new ResponseEntity<>(profileService.save(createProfileRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing profile", description = "Updates an existing profile with new data.")
    @PutMapping()
    public ResponseEntity<ProfileResponse> update(@RequestBody @Valid ProfileRequest profileRequest) {
        return new ResponseEntity<>(profileService.update(profileRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete a profile by ID", description = "Deletes a profile based on its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
