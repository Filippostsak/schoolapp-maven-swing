package filippos.tsakiris.scool_app_pro.service.students.exceptions;

/**
 * Exception thrown when an error occurs during student deletion.
 */
public class StudentDeleteException extends RuntimeException {

    /**
     * Constructs a new StudentDeleteException with the specified detail message.
     *
     * @param message the detail message.
     */
    public StudentDeleteException(String message) {
        super(message);
    }

    /**
     * Constructs a new StudentDeleteException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause   the cause of the exception.
     */
    public StudentDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new StudentDeleteException with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public StudentDeleteException(Throwable cause) {
        super(cause);
    }
}
