package filippos.tsakiris.scool_app_pro.dao.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOExceptionTest {

    @Test

    void testUserDAOException(){
        String message = "Test exception message";

        UserDAOException exception = new UserDAOException(message);

        assertEquals(message, exception.getMessage());
    }

}