package filippos.tsakiris.scool_app_pro.service.teacher;

import filippos.tsakiris.scool_app_pro.dao.exceptions.TeacherDAOException;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.Teacher;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherDeleteException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherNotFoundException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherUpdateException;

import java.util.List;

/**
 * Service interface for managing teachers.
 */
public interface ITeacherService {

    /**
     * Inserts a new teacher into the system.
     *
     * @param dto The DTO containing the teacher information.
     * @return The inserted teacher.
     * @throws TeacherDAOException If an error occurs while interacting with the data access layer.
     */
    Teacher insertTeacher(TeacherInsertDTO dto) throws TeacherDAOException;

    /**
     * Updates an existing teacher in the system.
     *
     * @param dto The DTO containing the updated teacher information.
     * @return The updated teacher.
     * @throws TeacherUpdateException If an error occurs while updating the teacher.
     */
    Teacher updateTeacher(TeacherUpdateDTO dto) throws TeacherUpdateException;

    /**
     * Deletes a teacher from the system.
     *
     * @param id The ID of the teacher to delete.
     * @throws TeacherDeleteException If an error occurs while deleting the teacher.
     * @throws TeacherDAOException    If an error occurs while interacting with the data access layer.
     */
    void deleteTeacher(Integer id) throws TeacherDeleteException, TeacherDAOException;

    /**
     * Retrieves a teacher by their ID.
     *
     * @param id The ID of the teacher to retrieve.
     * @return The retrieved teacher.
     * @throws TeacherNotFoundException If the teacher with the given ID is not found.
     * @throws TeacherDAOException      If an error occurs while interacting with the data access layer.
     */
    Teacher getTeacherById(Integer id) throws TeacherNotFoundException, TeacherDAOException;

    /**
     * Retrieves teachers by their last name.
     *
     * @param lastName The last name of the teachers to retrieve.
     * @return A list of teachers with the specified last name.
     * @throws TeacherNotFoundException If no teachers with the given last name are found.
     * @throws TeacherDAOException      If an error occurs while interacting with the data access layer.
     */
    List<Teacher> getTeacherByLastName(String lastName) throws TeacherNotFoundException, TeacherDAOException;

    /**
     * Retrieves teachers by their first name.
     *
     * @param firstName The first name of the teachers to retrieve.
     * @return A list of teachers with the specified first name.
     * @throws TeacherNotFoundException If no teachers with the given first name are found.
     * @throws TeacherDAOException      If an error occurs while interacting with the data access layer.
     */
    List<Teacher> getTeacherByFirstName(String firstName) throws TeacherNotFoundException, TeacherDAOException;

    /**
     * Retrieves teachers by their last name and first name.
     *
     * @param id        The ID of the teacher to retrieve.
     * @param lastName  The last name of the teachers to retrieve.
     * @param firstName The first name of the teachers to retrieve.
     * @return A list of teachers with the specified last name and first name.
     * @throws TeacherNotFoundException If no teachers with the given last name and first name are found.
     * @throws TeacherDAOException      If an error occurs while interacting with the data access layer.
     */
    List<Teacher> getTeacherByLastNameAndFirstName(Integer id, String lastName, String firstName) throws TeacherNotFoundException, TeacherDAOException;

    /**
     * Retrieves all teachers from the system.
     *
     * @return A list of all teachers in the system.
     * @throws TeacherNotFoundException If no teachers are found.
     * @throws TeacherDAOException      If an error occurs while interacting with the data access layer.
     */
    List<Teacher> getAllTeachers() throws TeacherNotFoundException, TeacherDAOException;
}
