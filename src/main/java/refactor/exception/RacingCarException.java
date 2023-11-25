package refactor.exception;

public class RacingCarException extends IllegalArgumentException {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public RacingCarException(String errorMessage) {
        super(ERROR_PREFIX + errorMessage);
    }
}
