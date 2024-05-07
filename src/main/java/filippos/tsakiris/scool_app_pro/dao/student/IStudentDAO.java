package filippos.tsakiris.scool_app_pro.dao.student;

import filippos.tsakiris.scool_app_pro.dao.exceptions.StudentDAOException;
import filippos.tsakiris.scool_app_pro.model.Student;

import java.util.List;

/**
 * Interface for accessing student data in the database.
 */
public interface IStudentDAO {

    /**
     * Inserts a new student into the database.
     *
     * @param student The student object to insert.
     * @return The inserted student object.
     * @throws StudentDAOException If an error occurs during insertion.
     */
    Student insert(Student student) throws StudentDAOException;

    /**
     * Updates an existing student in the database.
     *
     * @param student The student object to update.
     * @return The updated student object.
     * @throws StudentDAOException If an error occurs during update.
     */
    Student update(Student student) throws StudentDAOException;

    /**
     * Deletes a student from the database by ID.
     *
     * @param id The ID of the student to delete.
     * @throws StudentDAOException If an error occurs during deletion.
     */
    void delete(Integer id) throws StudentDAOException;

    /**
     * Retrieves a student from the database by ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The retrieved student object.
     * @throws StudentDAOException If an error occurs during retrieval.
     */
    Student getById(Integer id) throws StudentDAOException;

    /**
     * Retrieves a list of students from the database by last name.
     *
     * @param lastname The last name of the students to retrieve.
     * @return A list of students with the specified last name.
     * @throws StudentDAOException If an error occurs during retrieval.
     */
    List<Student> getByLastname(String lastname) throws StudentDAOException;

    /**
     * Retrieves all students from the database.
     *
     * @return A list containing all students in the database.
     * @throws StudentDAOException If an error occurs during retrieval.
     */
    List<Student> getAll() throws StudentDAOException;

    /**
     * Retrieves a list of students from the database by first name.
     *
     * @param firstname The first name of the students to retrieve.
     * @return A list of students with the specified first name.
     * @throws StudentDAOException If an error occurs during retrieval.
     */
    List<Student> getByFirstname(String firstname) throws StudentDAOException;

    /**
     * Retrieves a list of students from the database by last name and first name.
     *
     * @param id        The ID of the student to retrieve.
     * @param lastname  The last name of the student to retrieve.
     * @param firstname The first name of the student to retrieve.
     * @return A list of students with the specified last name and first name.
     * @throws StudentDAOException If an error occurs during retrieval.
     */
    List<Student> getByLastnameAndFirstname(Integer id, String lastname, String firstname) throws StudentDAOException;
}
