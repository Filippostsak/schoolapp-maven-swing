package filippos.tsakiris.scool_app_pro.service.students;

import filippos.tsakiris.scool_app_pro.dao.exceptions.StudentDAOException;
import filippos.tsakiris.scool_app_pro.dao.student.IStudentDAO;
import filippos.tsakiris.scool_app_pro.dto.studentdto.StudentInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.studentdto.StudentUpdateDTO;
import filippos.tsakiris.scool_app_pro.enums.Gender;
import filippos.tsakiris.scool_app_pro.model.Student;
import filippos.tsakiris.scool_app_pro.service.students.exceptions.StudentDeleteException;
import filippos.tsakiris.scool_app_pro.service.students.exceptions.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private IStudentDAO studentDAOMock;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student dummyStudent;
    private StudentInsertDTO insertDTO;
    private StudentUpdateDTO updateDTO;

    @BeforeEach
    void setUp() throws StudentDAOException {
        // Initialize common objects
        dummyStudent = new Student(1, "Jane", "Doe", Gender.F, new Date());
        insertDTO = new StudentInsertDTO(null, "Jane", "Doe", Gender.F, new Date());
        updateDTO = new StudentUpdateDTO(1, "Jane", "Updated", Gender.F, new Date());

        // Successful mock interactions
        when(studentDAOMock.insert(any(Student.class))).thenReturn(dummyStudent);
        when(studentDAOMock.update(any(Student.class))).thenReturn(dummyStudent);
        when(studentDAOMock.getById(1)).thenReturn(dummyStudent);

        // Mock exceptions for specific cases
        when(studentDAOMock.getById(999)).thenThrow(new StudentNotFoundException("No student found with ID: 999"));
        doNothing().when(studentDAOMock).delete(1);
        doThrow(new StudentDeleteException("Student with id: 999 not found")).when(studentDAOMock).delete(999);
    }

    @Test
    void insertStudent_WhenValidData_ShouldInsertSuccessfully() throws Exception {
        Student result = studentService.insertStudent(insertDTO);
        assertNotNull(result);
        assertEquals("Jane", result.getFirstName());
        verify(studentDAOMock).insert(any(Student.class));
    }

    @Test
    void updateStudent_WhenValidInput_ShouldUpdateSuccessfully() throws Exception {
        Student result = studentService.updateStudent(updateDTO);
        assertNotNull(result);
        assertEquals("Jane", result.getFirstName());
        verify(studentDAOMock).update(any(Student.class));
    }

    @Test
    void updateStudent_WhenNonExistingId_ShouldThrowStudentNotFoundException() throws StudentDAOException {
        when(studentDAOMock.update(any(Student.class))).thenThrow(new StudentNotFoundException("Student not found"));
        assertThrows(StudentNotFoundException.class, () -> studentService.updateStudent(updateDTO));
    }

    @Test
    void deleteStudent_WhenNonExistingId_ShouldThrowStudentDeleteException() throws StudentDAOException {
        assertThrows(StudentDeleteException.class, () -> studentService.deleteStudent(999));
        verify(studentDAOMock).delete(999);
    }

    @Test
    void getStudentById_WhenExistingId_ShouldReturnStudent() throws Exception {
        Student result = studentService.getStudentById(1);
        assertNotNull(result);
        assertEquals("Jane", result.getFirstName());
        verify(studentDAOMock).getById(1);
    }

    @Test
    void getStudentById_WhenNonExistingId_ShouldThrowStudentNotFoundException() {
        assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(999));
    }
}
