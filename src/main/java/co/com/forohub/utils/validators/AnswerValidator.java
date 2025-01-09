package co.com.forohub.utils.validators;

public class AnswerValidator {
    public static final String ID_NOT_NULL = "The answer id cannot be null";
    public static final String ID_POSITIVE = "The answer id must be a positive number";

    public static final String MESSAGE_NOT_BLANK = "The answer message cannot be null or empty";
    public static final String MESSAGE_SIZE = "The answer message must be between 1 and 500 characters";

    public static final String TOPIC_ID_NOT_NULL = "The answer topic id cannot be null";
    public static final String TOPIC_ID_POSITIVE = "The answer topic id must be a positive number";

    public static final String AUTHOR_ID_NOT_NULL = "The answer author id cannot be null";
    public static final String AUTHOR_ID_POSITIVE = "The answer author id must be a positive number";

    public static final String SOLUTION_NOT_BLANK = "The answer solution cannot be null or empty";
    public static final String SOLUTION_SIZE = "The answer solution must be between 1 and 500 characters";

    public static final String ANSWER_NOT_FOUND = "The answer with id %s not found";
}
