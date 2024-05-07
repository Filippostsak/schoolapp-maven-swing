package filippos.tsakiris.scool_app_pro.dao.student;

import filippos.tsakiris.scool_app_pro.dao.exceptions.StudentDAOException;
import filippos.tsakiris.scool_app_pro.dao.util.DBHelper;
import filippos.tsakiris.scool_app_pro.enums.Gender;
import filippos.tsakiris.scool_app_pro.model.Student;
import filippos.tsakiris.scool_app_pro.service.students.IStudentService;
import filippos.tsakiris.scool_app_pro.service.students.StudentServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {

    private static final IStudentDAO iStudentDAO = new StudentDAOImpl();
    private static IStudentService studentService;

    @BeforeAll
    public static void setUpClass() {
        studentService = new StudentServiceImpl(iStudentDAO);
    }

    @BeforeEach
    public void setUpEach() {
        try {
            DBHelper.eraseData();
        } catch (SQLException e) {
            fail("Failed to delete existing data: " + e.getMessage());
        }
        createDummyData();
    }


    @AfterEach
    public void tearDown() throws SQLException {
        DBHelper.eraseData();
    }

    @Test
    void testInsert() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setGender(Gender.M);

        StudentDAOImpl dao = new StudentDAOImpl();

        try {
            Student insertedStudent = dao.insert(student);
            assertNotNull(insertedStudent.getId());
        } catch (StudentDAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testGetById() {
        StudentDAOImpl dao = new StudentDAOImpl();

        try {
            Student student = dao.getById(1);
            assertNotNull(student);
        } catch (StudentDAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testUpdate() {
        Student student = new Student();
        student.setId(1);
        student.setFirstName("UpdatedFirstName");

        StudentDAOImpl dao = new StudentDAOImpl();

        try {
            Student updatedStudent = dao.update(student);
            assertEquals("UpdatedFirstName", updatedStudent.getFirstName());
        } catch (StudentDAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testDelete() {
        StudentDAOImpl dao = new StudentDAOImpl();
        try {
            dao.delete(1);
        } catch (StudentDAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    private void createDummyData() {
        try {
            Student student1 = new Student();
            student1.setFirstName("Alice");
            student1.setLastName("Smith");
            student1.setGender(Gender.F);
            iStudentDAO.insert(student1);

            Student student2 = new Student();
            student2.setFirstName("Bob");
            student2.setLastName("Johnson");
            student2.setGender(Gender.M);
            iStudentDAO.insert(student2);

        } catch (StudentDAOException e) {
            fail("Failed to create dummy data: " + e.getMessage());
        }
    }
}
