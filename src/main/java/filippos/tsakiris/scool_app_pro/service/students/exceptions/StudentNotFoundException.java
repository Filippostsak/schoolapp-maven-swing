package filippos.tsakiris.scool_app_pro.service.students.exceptions;

/**
 * Exception thrown when a student is not found.
 */
public class StudentNotFoundException extends RuntimeException {

    /**
     * Constructs a new StudentNotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new StudentNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause   the cause of the exception.
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new StudentNotFoundException with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
