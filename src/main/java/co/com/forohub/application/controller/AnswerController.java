package co.com.forohub.application.controller;

import co.com.forohub.domain.dto.answer.AnswerRequest;
import co.com.forohub.domain.dto.answer.AnswerResponse;
import co.com.forohub.domain.dto.answer.CreateAnswerRequest;
import co.com.forohub.application.service.IAnswerService;
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
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RequestMapping("/answers")
@RestController
@Tag(name = "Answers", description = "Endpoints for managing answers")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {
    private final IAnswerService answerService;

    @Operation(summary = "Get all answers", description = "Retrieves a paginated list of all answers.")
    @GetMapping()
    public ResponseEntity<Slice<AnswerResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(answerService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get answer by ID", description = "Retrieves a single answer by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(answerService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new answer", description = "Creates a new answer and returns the created object.")
    @PostMapping()
    public ResponseEntity<AnswerResponse> save(@RequestBody @Valid CreateAnswerRequest createAnswerRequest, UriComponentsBuilder uriComponentsBuilder) {
        return new ResponseEntity<>(answerService.save(createAnswerRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing answer", description = "Updates an existing answer with new data.")
    @PutMapping()
    public ResponseEntity<AnswerResponse> update(@RequestBody @Valid AnswerRequest answerRequest) {
        return new ResponseEntity<>(answerService.update(answerRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete an answer by ID", description = "Deletes an answer based on its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        answerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
