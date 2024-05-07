package filippos.tsakiris.scool_app_pro.dao.exceptions;

public class UserDAOException extends Exception{

        private static final long serialVersionUID = 1L;

        /**
        * Constructs a new UserDAOException with the specified detail message.
        *
        * @param message the detail message.
        */
        public UserDAOException(String message) {
            super(message);
        }
}
