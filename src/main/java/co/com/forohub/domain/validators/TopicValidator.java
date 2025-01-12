package co.com.forohub.domain.validators;

public class TopicValidator {
    public static final String ID_NOT_NULL = "The topic id cannot be null";
    public static final String ID_POSITIVE = "The topic id must be a positive number";

    public static final String TITLE_NOT_BLANK = "The topic title cannot be null or empty";
    public static final String TITLE_SIZE = "The topic title must be between 1 and 255 characters";

    public static final String MESSAGE_NOT_BLANK = "The topic message cannot be null or empty";
    public static final String MESSAGE_SIZE = "The topic message must be between 1 and 500 characters";

    public static final String AUTHOR_ID_NOT_NULL = "The topic author id cannot be null";

    public static final String COURSE_ID_NOT_NULL = "The topic course id cannot be null";

    public static final String ANSWER_IDS_NOT_NULL = "The topic answer id's cannot be null";

    public static final String TOPIC_NOT_FOUND = "The topic with id %s was not found";
}

