package co.com.forohub.controller;

import co.com.forohub.dto.answer.AnswerRequest;
import co.com.forohub.dto.answer.AnswerResponse;
import co.com.forohub.dto.answer.CreateAnswerRequest;
import co.com.forohub.service.IAnswerService;
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
@SecurityRequirement(name = "bearer-key")
public class AnswerController {
    private final IAnswerService answerService;

    @GetMapping()
    public ResponseEntity<Slice<AnswerResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(answerService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(answerService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AnswerResponse> save(@RequestBody @Valid CreateAnswerRequest createAnswerRequest, UriComponentsBuilder uriComponentsBuilder) {
        return new ResponseEntity<>(answerService.save(createAnswerRequest), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<AnswerResponse> update(@RequestBody @Valid AnswerRequest answerRequest) {
        return new ResponseEntity<>(answerService.update(answerRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        answerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
