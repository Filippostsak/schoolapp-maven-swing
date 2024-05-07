package filippos.tsakiris.scool_app_pro.dao.student;

import filippos.tsakiris.scool_app_pro.dao.exceptions.StudentDAOException;
import filippos.tsakiris.scool_app_pro.dao.teacher.ITeacherDAO;
import filippos.tsakiris.scool_app_pro.enums.Gender;
import filippos.tsakiris.scool_app_pro.model.Student;
import filippos.tsakiris.scool_app_pro.service.util.DBUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link IStudentDAO} interface for accessing and manipulating teacher data in the database.
 */
public class StudentDAOImpl implements IStudentDAO {


    @Override
    public Student insert(Student student) throws StudentDAOException {
        String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME, GENDER, BIRTH_DATE) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getGender().name());

            // Convert java.util.Date to java.sql.Date
            if (student.getDateOfBirth() != null) {
                ps.setDate(4, new java.sql.Date(student.getDateOfBirth().getTime()));
            } else {
                ps.setDate(4, null);
            }

            int n = ps.executeUpdate();
            if (n == 1) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        student.setId(rs.getInt(1));
                    }
                }
//                JOptionPane.showMessageDialog(null, "Student inserted successfully");
                return student;
            } else {
                throw new StudentDAOException("No student was inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to insert the student: " + e.getMessage());
        }
    }

    @Override
    public Student update(Student student) throws StudentDAOException {
        String sql = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ?, GENDER = ?, BIRTH_DATE = ? WHERE ID = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());

            // Handle null value for gender
            if (student.getGender() != null) {
                ps.setString(3, student.getGender().name());
            } else {
                ps.setNull(3, Types.VARCHAR);
            }

            if (student.getDateOfBirth() != null) {
                ps.setDate(4, new java.sql.Date(student.getDateOfBirth().getTime()));
            } else {
                ps.setDate(4, null);
            }
            ps.setInt(5, student.getId());

            int n = ps.executeUpdate();
            if (n == 1) {
                return student;
            } else {
                throw new StudentDAOException("No student was updated for ID: " + student.getId());
            }
        } catch (SQLException e) {
            throw new StudentDAOException("An error occurred while trying to update the student with ID: " + student.getId());
        }
    }


    @Override
    public void delete(Integer id) throws StudentDAOException {
        String sql = "DELETE FROM STUDENTS WHERE ID = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n != 1) {
                return;
            }
//            JOptionPane.showMessageDialog(null, "Student deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to delete a student with id: " + id);
        }
    }

    @Override
    public Student getById(Integer id) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstName(rs.getString("FIRSTNAME"));
                student.setLastName(rs.getString("LASTNAME"));
                String genderStr = rs.getString("GENDER");
                Gender gender = Gender.valueOf(genderStr);
                student.setDateOfBirth(rs.getDate("BIRTH_DATE"));
//                JOptionPane.showMessageDialog(null, "Student found successfully");
                return student;
            } else {
                throw new StudentDAOException("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to get a student with id: " + id);
        }
    }

    @Override
    public List<Student> getByLastname(String lastname) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE LASTNAME LIKE ?";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + lastname + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstName(rs.getString("FIRSTNAME"));
                student.setLastName(rs.getString("LASTNAME"));
                String genderStr = rs.getString("GENDER");
                Gender gender = null;
                if (genderStr != null) {
                    try {
                        gender = Gender.valueOf(genderStr);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
                student.setGender(gender);
                student.setDateOfBirth(rs.getDate("BIRTH_DATE"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to retrieve a student with lastname: " + lastname);
        }
        return students;
    }

    @Override
    public List<Student> getAll() throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstName(rs.getString("FIRSTNAME"));
                student.setLastName(rs.getString("LASTNAME"));

                String genderStr = rs.getString("GENDER");
                try {
                    Gender gender = Gender.valueOf(genderStr.trim().toUpperCase()); // Normalize and convert
                    student.setGender(gender);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid gender value from DB: " + genderStr);
                    student.setGender(null);
                }

                student.setDateOfBirth(rs.getDate("BIRTH_DATE"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to retrieve students: " + e.getMessage());
        }
        return students;
    }

    @Override
    public List<Student> getByFirstname(String firstname) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE FIRSTNAME = ?";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, firstname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstName(rs.getString("FIRSTNAME"));
                student.setLastName(rs.getString("LASTNAME"));
                String genderStr = (rs.getString("GENDER"));
                Gender gender = Gender.valueOf(genderStr);
                student.setDateOfBirth(rs.getDate("BIRTH_DATE"));
                students.add(student);
            }
//            JOptionPane.showMessageDialog(null, "Student retrieved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to retrieve a student with firstname: " + firstname);
        }
        return students;
    }

    @Override
    public List<Student> getByLastnameAndFirstname(Integer id, String lastname, String firstname) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE LASTNAME = ? AND FIRSTNAME = ?";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, lastname);
            ps.setString(2, firstname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstName(rs.getString("FIRSTNAME"));
                student.setLastName(rs.getString("LASTNAME"));
                String genderStr = (rs.getString("GENDER"));
                Gender gender = Gender.valueOf(genderStr);
                student.setDateOfBirth(rs.getDate("BIRTH_DATE"));
                students.add(student);
            }
            JOptionPane.showMessageDialog(null, "Student retrieved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("An error occurred while trying to retrieve a student with lastname: " + lastname + " and firstname: " + firstname);
        }
        return students;
    }
}
