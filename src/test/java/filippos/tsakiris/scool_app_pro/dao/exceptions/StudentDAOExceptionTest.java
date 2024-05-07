package filippos.tsakiris.scool_app_pro.dao.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentDAOExceptionTest {

    @Test
    void testConstructor() {
        String message = "Test exception message";

        StudentDAOException exception = new StudentDAOException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }
}
