package co.com.forohub.application.controller;

import co.com.forohub.domain.dto.course.CourseRequest;
import co.com.forohub.domain.dto.course.CourseResponse;
import co.com.forohub.domain.dto.course.CreateCourseRequest;
import co.com.forohub.application.service.ICourseService;
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
@RequestMapping("/courses")
@RestController
@Tag(name = "Courses", description = "Endpoints for managing courses")
@SecurityRequirement(name = "bearer-key")
public class CourseController {
    private final ICourseService courseService;

    @Operation(summary = "Get all courses", description = "Retrieves a paginated list of all courses.")
    @GetMapping()
    public ResponseEntity<Slice<CourseResponse>> findAll(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(courseService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get course by ID", description = "Retrieves a single course by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new course", description = "Creates a new course and returns the created object.")
    @PostMapping()
    public ResponseEntity<CourseResponse> save(@RequestBody @Valid CreateCourseRequest createCourseRequest) {
        return new ResponseEntity<>(courseService.save(createCourseRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing course", description = "Updates an existing course with new data.")
    @PutMapping()
    public ResponseEntity<CourseResponse> update(@RequestBody @Valid CourseRequest courseRequest) {
        return new ResponseEntity<>(courseService.update(courseRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete a course by ID", description = "Deletes a course based on its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
