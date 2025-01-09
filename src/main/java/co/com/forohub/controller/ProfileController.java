package co.com.forohub.controller;

import co.com.forohub.dto.profile.CreateProfileRequest;
import co.com.forohub.dto.profile.ProfileRequest;
import co.com.forohub.dto.profile.ProfileResponse;
import co.com.forohub.service.IProfileService;
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
@SecurityRequirement(name = "bearer-key")
public class ProfileController {
    private final IProfileService profileService;

    @GetMapping()
    public ResponseEntity<Slice<ProfileResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(profileService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProfileResponse> save(@RequestBody @Valid CreateProfileRequest createProfileRequest) {
        return new ResponseEntity<>(profileService.save(createProfileRequest), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ProfileResponse> update(@RequestBody @Valid ProfileRequest profileRequest) {
        return new ResponseEntity<>(profileService.update(profileRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
