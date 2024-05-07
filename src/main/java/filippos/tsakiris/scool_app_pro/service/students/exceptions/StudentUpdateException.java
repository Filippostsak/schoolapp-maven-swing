package filippos.tsakiris.scool_app_pro.service.students.exceptions;

import filippos.tsakiris.scool_app_pro.model.Student;

/**
 * Exception thrown when updating a student fails.
 */
public class StudentUpdateException extends RuntimeException {

    /**
     * Constructs a new StudentUpdateException with the specified detail message.
     *
     * @param message the detail message.
     */
    public StudentUpdateException(String message) {
        super(message);
    }

    /**
     * Constructs a new StudentUpdateException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause   the cause of the exception.
     */
    public StudentUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new StudentUpdateException with the specified cause.
     *
     * @param cause the cause of the exception.
     */
    public StudentUpdateException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new StudentUpdateException with the specified student's id.
     *
     * @param student the student object.
     */
    public StudentUpdateException(Student student) {
        super("Student with id: " + student.getId() + " update failed");
    }
}
