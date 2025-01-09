package co.com.forohub.mappers;

import co.com.forohub.domain.Course;
import co.com.forohub.dto.course.CourseRequest;
import co.com.forohub.dto.course.CourseResponse;
import co.com.forohub.dto.course.CreateCourseRequest;
import org.springframework.data.domain.Slice;

public class CourseMapper {
    public static CourseResponse toCourseResponse(Course course) {
        return CourseResponse.builder()
                .name(course.getName())
                .description(course.getDescription())
                .build();
    }

    public static Course toCourse(CreateCourseRequest createCourseRequest) {
        return Course.builder()
                .name(createCourseRequest.getName())
                .description(createCourseRequest.getDescription())
                .build();
    }

    public static Course toCourse(CourseRequest courseRequest) {
        return Course.builder()
                .id(courseRequest.getId())
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .build();
    }

    public static Slice<CourseResponse> toCourseResponseSlice(Slice<Course> courses) {
        return courses.map(CourseMapper::toCourseResponse);
    }
}