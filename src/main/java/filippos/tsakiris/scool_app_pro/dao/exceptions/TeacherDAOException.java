package filippos.tsakiris.scool_app_pro.dao.exceptions;

/**
 * Exception thrown when an error occurs in the TeacherDAO operations.
 */
public class TeacherDAOException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new TeacherDAOException with the specified detail message.
     *
     * @param message the detail message.
     */
    public TeacherDAOException(String message) {
        super(message);
    }
}
