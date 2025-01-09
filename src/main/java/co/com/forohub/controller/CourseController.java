package co.com.forohub.controller;

import co.com.forohub.dto.course.CourseRequest;
import co.com.forohub.dto.course.CourseResponse;
import co.com.forohub.dto.course.CreateCourseRequest;
import co.com.forohub.service.ICourseService;
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
@RequestMapping("/courses")
@RestController
@SecurityRequirement(name = "bearer-key")
public class CourseController {
    private final ICourseService courseService;

    @GetMapping()
    public ResponseEntity<Slice<CourseResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(courseService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CourseResponse> save(@RequestBody @Valid CreateCourseRequest createCourseRequest) {
        return new ResponseEntity<>(courseService.save(createCourseRequest), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CourseResponse> update(@RequestBody @Valid CourseRequest courseRequest) {
        return new ResponseEntity<>(courseService.update(courseRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
