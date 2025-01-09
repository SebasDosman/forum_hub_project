package co.com.forohub.utils.validators;

public class ProfileValidator {
    public static final String ID_NOT_NULL = "The profile id cannot be null";
    public static final String ID_POSITIVE = "The profile id must be a positive number";

    public static final String NAME_NOT_BLANK = "The profile name cannot be null or empty";
    public static final String NAME_SIZE = "The profile name must be between 1 and 255 characters";

    public static final String PROFILE_NOT_FOUND = "The profile with id %s was not found";
}
