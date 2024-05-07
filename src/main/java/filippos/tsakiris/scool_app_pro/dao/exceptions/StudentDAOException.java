package filippos.tsakiris.scool_app_pro.dao.exceptions;

/**
 * Exception thrown when an error occurs in the StudentDAO operations.
 */
public class StudentDAOException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new StudentDAOException with the specified detail message.
     *
     * @param message the detail message.
     */
    public StudentDAOException(String message) {
        super(message);
    }
}
