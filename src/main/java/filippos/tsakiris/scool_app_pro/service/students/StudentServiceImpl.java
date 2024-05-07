package filippos.tsakiris.scool_app_pro.service.students;

import filippos.tsakiris.scool_app_pro.dao.exceptions.StudentDAOException;
import filippos.tsakiris.scool_app_pro.dao.student.IStudentDAO;
import filippos.tsakiris.scool_app_pro.dto.studentdto.StudentInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.studentdto.StudentUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.Student;
import filippos.tsakiris.scool_app_pro.service.students.exceptions.StudentDeleteException;
import filippos.tsakiris.scool_app_pro.service.students.exceptions.StudentNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * Service implementation for managing students.
 */
public class StudentServiceImpl implements IStudentService{

private final IStudentDAO studentDAO;

    public StudentServiceImpl(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student insertStudent(StudentInsertDTO dto) throws StudentNotFoundException, StudentDAOException {
        if(dto == null) return null;
        Student student = null;
        try {
            // Convert java.util.Date to java.sql.Date
            Date utilDate = dto.getDateOfBirth();
            java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDate.getTime());
            student = new Student(
                    dto.getId(),
                    dto.getFirstName(),
                    dto.getLastName(),
                    dto.getGender(),
                    sqlDateOfBirth
            );
            return studentDAO.insert(student);
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to insert a student: " + student);
        }
    }


    @Override
    public Student updateStudent(StudentUpdateDTO dto) throws StudentNotFoundException {
        if (dto == null) return null;
        Student student = null;
        try {
            student = map(dto);
            if (student.getId() == null) {
                throw new StudentNotFoundException(String.valueOf(student));
            }
            return studentDAO.update(student);
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentNotFoundException("An error occurred while trying to update a student" + student);
        }
    }

    @Override
    public void deleteStudent(Integer id) throws StudentNotFoundException, StudentDeleteException {
    if (id == null) {
        throw new IllegalArgumentException("ID cannot be null");
    }
    try {
        if (studentDAO.getById(id) == null) {
            throw new StudentDeleteException("Student with id: " + id + " not found");
        }
        studentDAO.delete(id);
    } catch (StudentDAOException e) {
        e.printStackTrace();
        throw new StudentDeleteException("An error occurred while trying to delete a student with id: " + id);
    }
}

    @Override
    public Student getStudentById(Integer id) throws StudentNotFoundException, StudentDAOException {
        if(id == null) return null;
        try{
            if(studentDAO.getById(id) == null
            ){
                throw new StudentNotFoundException("Student with id: " + id + " not found");
            }
            return studentDAO.getById(id);
        }catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentNotFoundException("An error occurred while trying to get a student with id: " + id);

        }


    }

    @Override
    public List<Student> getStudentByLastName(String lastName) throws StudentNotFoundException {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        try {
            List<Student> students = studentDAO.getByLastname(lastName);
            if (students.isEmpty()) {
                throw new StudentNotFoundException("Student with lastname: " + lastName + " not found");
            }
            return students;
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentNotFoundException("An error occurred while trying to get a student with lastname: " + lastName);
        }
    }


    @Override
    public List<Student> getStudentByFirstName(String firstName) throws StudentNotFoundException, StudentDAOException {
        if(firstName == null) return null;
        try{
            if(studentDAO.getByFirstname(firstName) == null){
                throw new StudentNotFoundException("Student with firstname: " + firstName + " not found");
            }
            return studentDAO.getByFirstname(firstName);
        }catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentNotFoundException("An error occurred while trying to get a student with firstname: " + firstName);
        }
    }

    @Override
    public List<Student> getStudentByLastNameAndFirstName(Integer id, String lastName, String firstName) throws StudentNotFoundException, StudentDAOException {
       if(id == null) {
           throw new IllegalArgumentException("ID cannot be null");
       }
       try{
              if(studentDAO.getByLastnameAndFirstname(id, lastName, firstName) == null){
                throw new StudentNotFoundException("Student with id: " + id + " not found");
              }
              return studentDAO.getByLastnameAndFirstname(id, lastName, firstName);
         }catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentNotFoundException("An error occurred while trying to get a student with id: " + id);
       }
    }

    @Override
    public List<Student> getAllStudents() throws StudentNotFoundException, StudentDAOException {
        if(studentDAO.getAll() == null){
            throw new StudentNotFoundException("No students found");
        }
        try{
            return studentDAO.getAll();
        }catch (StudentDAOException e) {
            e.printStackTrace();
            throw new StudentNotFoundException("An error occurred while trying to get all students");

        }
    }

    private Student map(StudentInsertDTO dto) {
    if(dto == null){
        throw new IllegalArgumentException("DTO cannot be null");
    }
    return new Student(null, dto.getFirstName(), dto.getLastName(), dto.getGender(), dto.getDateOfBirth());
    }

    private Student map(StudentUpdateDTO dto) {
    if(dto == null){
        throw new IllegalArgumentException("DTO cannot be null");
    }
    return new Student(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getGender(), dto.getDateOfBirth());
    }

}
