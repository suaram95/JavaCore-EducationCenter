package educationCenter.exception;

public class DuplicateStudentException extends Exception {

    public DuplicateStudentException() {
    }

    public DuplicateStudentException(String message) {
        super(message);
    }

    public DuplicateStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateStudentException(Throwable cause) {
        super(cause);
    }

    public DuplicateStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
