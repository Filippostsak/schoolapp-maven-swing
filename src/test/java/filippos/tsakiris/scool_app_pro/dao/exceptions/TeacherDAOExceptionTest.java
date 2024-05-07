package filippos.tsakiris.scool_app_pro.dao.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherDAOExceptionTest {

    @Test

    void testTeacherDAOException(){
        String message = "Test exception message";

        TeacherDAOException exception = new TeacherDAOException(message);

        assertEquals(message, exception.getMessage());
    }

}