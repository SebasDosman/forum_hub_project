package co.com.forohub.utils.validators;

public class CourseValidator {
    public static final String ID_NOT_NULL = "The course id cannot be null";
    public static final String ID_POSITIVE = "The course id must be a positive number";

    public static final String NAME_NOT_BLANK = "The course name cannot be null or empty";
    public static final String NAME_SIZE = "The course name must be between 1 and 255 characters";

    public static final String DESCRIPTION_NOT_BLANK = "The course description cannot be null or empty";
    public static final String DESCRIPTION_SIZE = "The course description must be between 1 and 500 characters";

    public static final String COURSE_NOT_FOUND = "The course with id %s was not found";
}
