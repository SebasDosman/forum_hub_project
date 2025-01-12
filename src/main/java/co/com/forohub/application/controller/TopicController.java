package co.com.forohub.application.controller;

import co.com.forohub.domain.dto.topic.CreateTopicRequest;
import co.com.forohub.domain.dto.topic.TopicRequest;
import co.com.forohub.domain.dto.topic.TopicResponse;
import co.com.forohub.application.service.ITopicService;
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
@RequestMapping("/topics")
@RestController
@Tag(name = "Topics", description = "Endpoints for managing discussion topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    private final ITopicService topicService;

    @Operation(summary = "Get all topics", description = "Retrieves a paginated list of all topics.")
    @GetMapping()
    public ResponseEntity<Slice<TopicResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(topicService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get active topics", description = "Retrieves a paginated list of all topics with active status (true).")
    @GetMapping("/status")
    public ResponseEntity<Slice<TopicResponse>> findAllByStatusTrue(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(topicService.findAllByStatusTrue(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get topic by ID", description = "Retrieves a single topic by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(topicService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new topic", description = "Creates a new topic and returns the created object.")
    @PostMapping()
    public ResponseEntity<TopicResponse> save(@RequestBody @Valid CreateTopicRequest createTopicRequest) {
        return new ResponseEntity<>(topicService.save(createTopicRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing topic", description = "Updates an existing topic with new data.")
    @PutMapping()
    public ResponseEntity<TopicResponse> update(@RequestBody @Valid TopicRequest topicRequest) {
        return new ResponseEntity<>(topicService.update(topicRequest), HttpStatus.OK);
    }

    @Operation(summary = "Update topic status", description = "Updates the status of a topic by its ID.")
    @PutMapping("/status/{id}")
    public ResponseEntity<TopicResponse> updateStatus(@PathVariable Long id) {
        return new ResponseEntity<>(topicService.updateStatus(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a topic", description = "Deletes a topic based on its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        topicService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
