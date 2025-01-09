package co.com.forohub.service;

import co.com.forohub.dto.course.CourseRequest;
import co.com.forohub.dto.course.CourseResponse;
import co.com.forohub.dto.course.CreateCourseRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ICourseService {
    Slice<CourseResponse> findAll(Pageable pageable);
    CourseResponse findById(Long id);
    CourseResponse save(CreateCourseRequest createCourseRequest);
    CourseResponse update(CourseRequest courseRequest);
    void delete(Long id);
}
