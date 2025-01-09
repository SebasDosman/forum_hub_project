package co.com.forohub.controller;

import co.com.forohub.dto.topic.CreateTopicRequest;
import co.com.forohub.dto.topic.TopicRequest;
import co.com.forohub.dto.topic.TopicResponse;
import co.com.forohub.service.ITopicService;
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
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    private final ITopicService topicService;

    @GetMapping()
    public ResponseEntity<Slice<TopicResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(topicService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Slice<TopicResponse>> findAllByStatusTrue(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(topicService.findAllByStatusTrue(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(topicService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TopicResponse> save(@RequestBody @Valid CreateTopicRequest createTopicRequest) {
        return new ResponseEntity<>(topicService.save(createTopicRequest), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<TopicResponse> update(@RequestBody @Valid TopicRequest topicRequest) {
        return new ResponseEntity<>(topicService.update(topicRequest), HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<TopicResponse> updateStatus(@PathVariable Long id) {
        return new ResponseEntity<>(topicService.updateStatus(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        topicService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
