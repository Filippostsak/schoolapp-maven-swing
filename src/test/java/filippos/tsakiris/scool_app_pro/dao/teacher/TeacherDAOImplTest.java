package filippos.tsakiris.scool_app_pro.dao.teacher;

import filippos.tsakiris.scool_app_pro.dao.exceptions.TeacherDAOException;
import filippos.tsakiris.scool_app_pro.dao.util.DBHelper;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.Teacher;
import filippos.tsakiris.scool_app_pro.service.teacher.ITeacherService;
import filippos.tsakiris.scool_app_pro.service.teacher.TeacherServiceImpl;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherDeleteException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherNotFoundException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherUpdateException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TeacherDAOImplTest {

    private static final ITeacherDAO iTeacherDAO = new TeacherDAOImpl();
    private static ITeacherService teacherService;

    @BeforeAll
    public static void setUpClass() {
        teacherService = new TeacherServiceImpl(iTeacherDAO);
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
        TeacherInsertDTO teacherDTO = new TeacherInsertDTO();
        teacherDTO.setFirstname("John");
        teacherDTO.setLastname("Doe");

        try {
            Teacher insertedTeacher = teacherService.insertTeacher(teacherDTO);
            assertNotNull(insertedTeacher.getId());
        } catch (TeacherDAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testGetById() {
        try {
            Teacher teacher = teacherService.getTeacherById(1);
            assertNotNull(teacher);
        } catch (TeacherDAOException e) {
            fail("Exception thrown: " + e.getMessage());
        } catch (TeacherNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testUpdate() throws TeacherNotFoundException{
        try {
            Teacher teacher = teacherService.getTeacherById(1);
            TeacherUpdateDTO updateDTO = new TeacherUpdateDTO();
            updateDTO.setId(teacher.getId());
            updateDTO.setFirstname("UpdatedFirstName");
            Teacher updatedTeacher = teacherService.updateTeacher(updateDTO);
            assertEquals("UpdatedFirstName", updatedTeacher.getFirstName());
        } catch (TeacherDAOException | TeacherNotFoundException | TeacherUpdateException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testDelete() {
        try {
            teacherService.deleteTeacher(1);
        } catch (TeacherDAOException | TeacherDeleteException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    private void createDummyData() {
        try {
            TeacherInsertDTO teacherDTO1 = new TeacherInsertDTO();
            teacherDTO1.setFirstname("Alice");
            teacherDTO1.setLastname("Smith");
            teacherService.insertTeacher(teacherDTO1);

            TeacherInsertDTO teacherDTO2 = new TeacherInsertDTO();
            teacherDTO2.setFirstname("Bob");
            teacherDTO2.setLastname("Johnson");
            teacherService.insertTeacher(teacherDTO2);

        } catch (TeacherDAOException e) {
            fail("Failed to create dummy data: " + e.getMessage());
        }
    }
}
