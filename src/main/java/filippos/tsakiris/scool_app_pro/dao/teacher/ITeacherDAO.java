package filippos.tsakiris.scool_app_pro.dao.teacher;

import filippos.tsakiris.scool_app_pro.dao.exceptions.TeacherDAOException;
import filippos.tsakiris.scool_app_pro.model.Teacher;

import java.util.List;

/**
 * An interface that defines methods to access and manipulate teacher data in the database.
 */
public interface ITeacherDAO {
    /**
     * Inserts a new teacher into the database.
     *
     * @param teacher The teacher object to be inserted.
     * @return The inserted teacher object.
     * @throws TeacherDAOException If an error occurs while inserting the teacher.
     */
    Teacher insert(Teacher teacher) throws TeacherDAOException;

    /**
     * Updates an existing teacher in the database.
     *
     * @param teacher The teacher object to be updated.
     * @return The updated teacher object.
     * @throws TeacherDAOException If an error occurs while updating the teacher.
     */
    Teacher update(Teacher teacher) throws TeacherDAOException;

    /**
     * Deletes a teacher from the database by ID.
     *
     * @param id The ID of the teacher to be deleted.
     * @throws TeacherDAOException If an error occurs while deleting the teacher.
     */
    void delete(Integer id) throws TeacherDAOException;

    /**
     * Retrieves a teacher from the database by ID.
     *
     * @param id The ID of the teacher to be retrieved.
     * @return The retrieved teacher object.
     * @throws TeacherDAOException If an error occurs while retrieving the teacher.
     */
    Teacher getById(Integer id) throws TeacherDAOException;

    /**
     * Retrieves a list of teachers from the database by last name.
     *
     * @param lastname The last name of the teachers to be retrieved.
     * @return A list of teacher objects matching the specified last name.
     * @throws TeacherDAOException If an error occurs while retrieving the teachers.
     */
    List<Teacher> getByLastname(String lastname) throws TeacherDAOException;

    /**
     * Retrieves a list of all teachers from the database.
     *
     * @return A list of all teacher objects stored in the database.
     * @throws TeacherDAOException If an error occurs while retrieving the teachers.
     */
    List<Teacher> getAll() throws TeacherDAOException;

    /**
     * Retrieves a list of teachers from the database by first name.
     *
     * @param firstname The first name of the teachers to be retrieved.
     * @return A list of teacher objects matching the specified first name.
     * @throws TeacherDAOException If an error occurs while retrieving the teachers.
     */
    List<Teacher> getByFirstname(String firstname) throws TeacherDAOException;

    /**
     * Retrieves a list of teachers from the database by last name and first name.
     *
     * @param id        The ID of the teacher.
     * @param lastname  The last name of the teacher.
     * @param firstname The first name of the teacher.
     * @return A list of teacher objects matching the specified last name and first name.
     * @throws TeacherDAOException If an error occurs while retrieving the teachers.
     */
    List<Teacher> getByLastnameAndFirstname(Integer id, String lastname, String firstname) throws TeacherDAOException;
}
