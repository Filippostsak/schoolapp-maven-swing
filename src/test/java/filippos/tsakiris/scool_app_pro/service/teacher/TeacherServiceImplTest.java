package filippos.tsakiris.scool_app_pro.service.teacher;

import filippos.tsakiris.scool_app_pro.dao.exceptions.TeacherDAOException;
import filippos.tsakiris.scool_app_pro.dao.teacher.ITeacherDAO;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.Teacher;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherNotFoundException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherUpdateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @Mock
    private ITeacherDAO teacherDAOMock;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @BeforeEach
    void setUp() {
        // Setup is handled by Mockito; additional setup can be done here if necessary.
    }

    @Test
    void insertTeacher_WhenValidData_ShouldReturnTeacher() throws TeacherDAOException {
        // Arrange
        TeacherInsertDTO dto = new TeacherInsertDTO(null, "John", "Doe");
        Teacher expectedTeacher = new Teacher(1, "John", "Doe");
        when(teacherDAOMock.insert(any(Teacher.class))).thenReturn(expectedTeacher);

        // Act
        Teacher result = teacherService.insertTeacher(dto);

        // Assert
        assertNotNull(result);
        assertEquals(expectedTeacher.getFirstName(), result.getFirstName());
        verify(teacherDAOMock).insert(any(Teacher.class));
    }

    @Test
    void updateTeacher_WhenValidInput_ShouldUpdateSuccessfully() throws TeacherDAOException, TeacherUpdateException {
        // Arrange
        TeacherUpdateDTO dto = new TeacherUpdateDTO(1, "John", "Updated");
        Teacher expectedTeacher = new Teacher(1, "John", "Updated");
        when(teacherDAOMock.update(any(Teacher.class))).thenReturn(expectedTeacher);

        // Act
        Teacher result = teacherService.updateTeacher(dto);

        // Assert
        assertNotNull(result);
        assertEquals(expectedTeacher.getFirstName(), result.getFirstName());
        verify(teacherDAOMock).update(any(Teacher.class));
    }

    @Test
    void deleteTeacher_WhenExistingTeacher_ShouldDeleteSuccessfully() throws TeacherDAOException {
        // Arrange
        Teacher existingTeacher = new Teacher(1, "John", "Doe");
        when(teacherDAOMock.getById(1)).thenReturn(existingTeacher);  // Ensuring the teacher exists
        doNothing().when(teacherDAOMock).delete(1);

        // Act & Assert
        assertDoesNotThrow(() -> teacherService.deleteTeacher(1));
        verify(teacherDAOMock).delete(1);
    }


    @Test
    void getTeacherById_WhenExistingId_ShouldReturnTeacher() throws TeacherDAOException, TeacherNotFoundException {
        // Arrange
        Teacher expectedTeacher = new Teacher(1, "John", "Doe");
        when(teacherDAOMock.getById(1)).thenReturn(expectedTeacher);

        // Act
        Teacher result = teacherService.getTeacherById(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedTeacher.getFirstName(), result.getFirstName());
    }

    @Test
    void getTeacherByLastName_WhenExistingLastName_ShouldReturnTeachers() throws TeacherDAOException, TeacherNotFoundException, TeacherDAOException {
        // Arrange
        List<Teacher> expectedTeachers = Collections.singletonList(new Teacher(1, "John", "Doe"));
        when(teacherDAOMock.getByLastname("Doe")).thenReturn(expectedTeachers);

        // Act
        List<Teacher> results = teacherService.getTeacherByLastName("Doe");

        // Assert
        assertFalse(results.isEmpty());
        assertEquals(expectedTeachers.size(), results.size());
        assertEquals(expectedTeachers.get(0).getLastName(), results.get(0).getLastName());
    }

    // Additional tests for other methods can be added here following the same pattern
}
