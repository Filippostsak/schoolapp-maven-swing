package filippos.tsakiris.scool_app_pro.service.teacher;

import filippos.tsakiris.scool_app_pro.dao.exceptions.TeacherDAOException;
import filippos.tsakiris.scool_app_pro.dao.teacher.ITeacherDAO;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.teacherdto.TeacherUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.Teacher;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherDeleteException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherNotFoundException;
import filippos.tsakiris.scool_app_pro.service.teacher.exceptions.TeacherUpdateException;

import java.util.List;

/**
 * Service implementation for managing teachers.
 */
public class TeacherServiceImpl implements ITeacherService{

    private final ITeacherDAO teacherDAO;

    public TeacherServiceImpl(ITeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }


    @Override
    public Teacher insertTeacher(TeacherInsertDTO dto) throws TeacherDAOException {
        if(dto == null) return null;
        Teacher teacher = null;
        try{
            teacher = map(dto);
            return teacherDAO.insert(teacher);
        }catch (TeacherDAOException e) {
            e.printStackTrace();
            throw  new TeacherDAOException("An error occurred while trying to insert a teacher" + teacher);
        }
    }

    @Override
    public Teacher updateTeacher(TeacherUpdateDTO dto) throws TeacherUpdateException {
        if(dto == null) return null;
        Teacher teacher = null;
        try{
            teacher = map(dto);
            if(teacher.getId() == null){
                throw new TeacherUpdateException(teacher);
            }
            return teacherDAO.update(teacher);
        }catch (TeacherDAOException e) {
            e.printStackTrace();
            throw new TeacherUpdateException("An error occurred while trying to update a teacher" + teacher);
        }
    }


    @Override
    public void deleteTeacher(Integer id) throws TeacherDeleteException, TeacherDAOException {
        if(id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        try {
            if(teacherDAO.getById(id) == null) {
                throw new TeacherDeleteException("Teacher with id: " + id + " not found");
            }
            teacherDAO.delete(id);
        } catch (TeacherDAOException e) {
            e.printStackTrace();
            throw new TeacherDeleteException("An error occurred while trying to delete a teacher with id: " + id);
        }
    }


    @Override
    public Teacher getTeacherById(Integer id) throws TeacherNotFoundException, TeacherDAOException {
        if(id == null) return null;
        try{
            if(teacherDAO.getById(id) == null
            ){
                throw new TeacherNotFoundException("Teacher with id: " + id + " not found");
            }
            return teacherDAO.getById(id);
        }catch (TeacherDAOException e) {
            e.printStackTrace();
            throw new TeacherNotFoundException("An error occurred while trying to get a teacher with id: " + id);
        }
    }

    @Override
    public List<Teacher> getTeacherByLastName(String lastName) throws TeacherNotFoundException, TeacherDAOException {
        if(lastName == null) return null;
        try{
            if(teacherDAO.getByLastname(lastName) == null){
                throw new TeacherNotFoundException("Teacher with lastname: " + lastName + " not found");
            }
            return teacherDAO.getByLastname(lastName);
        }catch (TeacherDAOException e) {
            e.printStackTrace();
            throw new TeacherNotFoundException("An error occurred while trying to get a teacher with lastname: " + lastName);
        }
    }

    @Override
    public List<Teacher> getTeacherByFirstName(String firstName) throws TeacherNotFoundException {
        if(firstName == null) return null;
        try{
            if(teacherDAO.getByFirstname(firstName) == null){
                throw new TeacherNotFoundException("Teacher with firstname: " + firstName + " not found");
            }
            return teacherDAO.getByFirstname(firstName);
        }catch (TeacherDAOException e) {
            e.printStackTrace();
            throw new TeacherNotFoundException("An error occurred while trying to get a teacher with firstname: " + firstName);
        }
    }

    @Override
    public List<Teacher> getTeacherByLastNameAndFirstName(Integer id, String lastName, String firstName) throws TeacherNotFoundException {
        if(lastName == null || firstName == null) return null;
        try{
            if(teacherDAO.getByLastnameAndFirstname(id, lastName, firstName) == null){
                throw new TeacherNotFoundException("Teacher with lastname: " + lastName + " and firstname: " + firstName + " not found");
            }
            return teacherDAO.getByLastnameAndFirstname(id, lastName, firstName);
        }catch (TeacherDAOException e) {
            e.printStackTrace();
            throw new TeacherNotFoundException("An error occurred while trying to get a teacher with lastname: " + lastName + " and firstname: " + firstName);
        }
    }

    @Override
    public List<Teacher> getAllTeachers() throws TeacherNotFoundException, TeacherDAOException {
        if(teacherDAO.getAll().isEmpty()){
            throw new TeacherNotFoundException("No teachers found");
        }
        return teacherDAO.getAll();
    }

    //Mappers

    private Teacher map(TeacherInsertDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("TeacherInsertDTO is null");
        }
        // Ensure SSN is included in the mapping.
        return new Teacher(null, dto.getFirstname(), dto.getLastname());
    }


    private Teacher map(TeacherUpdateDTO dto){
        if(dto == null){
            throw  new IllegalArgumentException("TeacherUpdateDTO is null");
        }
        return new Teacher(dto.getId(), dto.getFirstname(), dto.getLastname());
    }
}
