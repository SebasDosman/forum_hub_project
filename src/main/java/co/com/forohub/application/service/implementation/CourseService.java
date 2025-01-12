package co.com.forohub.application.service.implementation;

import co.com.forohub.domain.entities.Course;
import co.com.forohub.domain.dto.course.CourseRequest;
import co.com.forohub.domain.dto.course.CourseResponse;
import co.com.forohub.domain.dto.course.CreateCourseRequest;
import co.com.forohub.domain.exceptions.NotFoundException;
import co.com.forohub.domain.mappers.CourseMapper;
import co.com.forohub.application.repository.CourseRepository;
import co.com.forohub.application.service.ICourseService;
import co.com.forohub.domain.validators.CourseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public Slice<CourseResponse> findAll(Pageable pageable) {
        return CourseMapper.toCourseResponseSlice(courseRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public CourseResponse findById(Long id) {
        if (!courseRepository.existsById(id)) throw new NotFoundException(String.format(CourseValidator.COURSE_NOT_FOUND, id));

        return CourseMapper.toCourseResponse(courseRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public CourseResponse save(CreateCourseRequest createCourseRequest) {
        Course course = CourseMapper.toCourse(createCourseRequest);

        return CourseMapper.toCourseResponse(courseRepository.save(course));
    }

    @Override
    @Transactional
    public CourseResponse update(CourseRequest courseRequest) {
        if (!courseRepository.existsById(courseRequest.getId())) throw new NotFoundException(String.format(CourseValidator.COURSE_NOT_FOUND, courseRequest.getId()));

        Course course = CourseMapper.toCourse(courseRequest);

        return CourseMapper.toCourseResponse(courseRepository.save(course));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!courseRepository.existsById(id)) throw new NotFoundException(String.format(CourseValidator.COURSE_NOT_FOUND, id));

        courseRepository.deleteById(id);
    }
}
