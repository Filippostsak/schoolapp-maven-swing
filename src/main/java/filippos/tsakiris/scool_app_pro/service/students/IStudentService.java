package filippos.tsakiris.scool_app_pro.service.students;

import filippos.tsakiris.scool_app_pro.dao.exceptions.StudentDAOException;
import filippos.tsakiris.scool_app_pro.dto.studentdto.StudentInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.studentdto.StudentUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.Student;
import filippos.tsakiris.scool_app_pro.service.students.exceptions.StudentDeleteException;
import filippos.tsakiris.scool_app_pro.service.students.exceptions.StudentNotFoundException;

import java.util.List;

/**
 * Service interface for managing students.
 */
public interface IStudentService {

    /**
     * Inserts a new student.
     *
     * @param dto The data transfer object containing the information of the student to be inserted.
     * @return The inserted student.
     * @throws StudentNotFoundException If the student is not found.
     * @throws StudentDAOException      If an error occurs while accessing the data store.
     */
    Student insertStudent(StudentInsertDTO dto) throws StudentNotFoundException, StudentDAOException;

    /**
     * Updates an existing student.
     *
     * @param dto The data transfer object containing the updated information of the student.
     * @return The updated student.
     * @throws StudentNotFoundException If the student is not found.
     */
    Student updateStudent(StudentUpdateDTO dto) throws StudentNotFoundException;

    /**
     * Deletes a student by ID.
     *
     * @param id The ID of the student to delete.
     * @throws StudentNotFoundException If the student is not found.
     * @throws StudentDeleteException   If an error occurs while deleting the student.
     */
    void deleteStudent(Integer id) throws StudentNotFoundException, StudentDeleteException;

    /**
     * Retrieves a student by ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The retrieved student.
     * @throws StudentNotFoundException If the student is not found.
     * @throws StudentDAOException      If an error occurs while accessing the data store.
     */
    Student getStudentById(Integer id) throws StudentNotFoundException, StudentDAOException;

    /**
     * Retrieves a list of students by last name.
     *
     * @param lastName The last name of the students to retrieve.
     * @return A list of students with the specified last name.
     * @throws StudentNotFoundException If no students are found with the specified last name.
     * @throws StudentDAOException      If an error occurs while accessing the data store.
     */
    List<Student> getStudentByLastName(String lastName) throws StudentNotFoundException, StudentDAOException;

    /**
     * Retrieves a list of students by first name.
     *
     * @param firstName The first name of the students to retrieve.
     * @return A list of students with the specified first name.
     * @throws StudentNotFoundException If no students are found with the specified first name.
     * @throws StudentDAOException      If an error occurs while accessing the data store.
     */
    List<Student> getStudentByFirstName(String firstName) throws StudentNotFoundException, StudentDAOException;

    /**
     * Retrieves a list of students by last name and first name.
     *
     * @param id        The ID of the student.
     * @param lastName  The last name of the students to retrieve.
     * @param firstName The first name of the students to retrieve.
     * @return A list of students with the specified last name and first name.
     * @throws StudentNotFoundException If no students are found with the specified last name and first name.
     * @throws StudentDAOException      If an error occurs while accessing the data store.
     */
    List<Student> getStudentByLastNameAndFirstName(Integer id, String lastName, String firstName) throws StudentNotFoundException, StudentDAOException;

    /**
     * Retrieves all students.
     *
     * @return A list of all students.
     * @throws StudentNotFoundException If no students are found.
     * @throws StudentDAOException      If an error occurs while accessing the data store.
     */
    List<Student> getAllStudents() throws StudentNotFoundException, StudentDAOException;
}
