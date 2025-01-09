package co.com.forohub.utils.validators;

public class UserValidator {
    public static final String ID_NOT_NULL = "The user id cannot be null";
    public static final String ID_POSITIVE = "The user id must be a positive number";

    public static final String NAME_NOT_BLANK = "The user name cannot be null or empty";
    public static final String NAME_SIZE = "The user name must be between 1 and 255 characters";
    public static final String NAME_PATTERN = "The user name must contain only letters, numbers, spaces, hyphens and underscores";
    public static final String NAME_REGEX = "^[a-zA-Z0-9_ -]*$";

    public static final String EMAIL_NOT_BLANK = "The user email cannot be null or empty";
    public static final String EMAIL_SIZE = "The user email must be between 1 and 255 characters";
    public static final String EMAIL_PATTERN = "The user email must be a valid email address";
    public static final String EMAIL_ALREADY_EXISTS = "The user with email %s already exists";

    public static final String PASSWORD_NOT_BLANK = "The user password cannot be null or empty";
    public static final String PASSWORD_SIZE = "The user password must be between 1 and 255 characters";
    public static final String PASSWORD_PATTERN = "The user password must contain at least one uppercase letter, one lowercase letter, one number and one special character";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$";

    public static final String PROFILES_IDS_NOT_NULL = "The user profiles id's cannot be null";

    public static final String USER_NOT_FOUND = "The user with id %s was not found";
}
