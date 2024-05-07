package filippos.tsakiris.scool_app_pro.dao.teacher;

import filippos.tsakiris.scool_app_pro.dao.exceptions.TeacherDAOException;
import filippos.tsakiris.scool_app_pro.model.Teacher;
import filippos.tsakiris.scool_app_pro.service.util.DBUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link ITeacherDAO} interface for accessing and manipulating teacher data in the database.
 */

public class TeacherDAOImpl implements ITeacherDAO{


    @Override
    public Teacher insert(Teacher teacher) throws TeacherDAOException {
        String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            String firstname = teacher.getFirstName();
            String lastname = teacher.getLastName();

            ps.setString(1, firstname);
            ps.setString(2, lastname);

            int n = ps.executeUpdate();
            if (n != 1) {
                return null;
            }

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                teacher.setId(id);
            } else {
                throw new TeacherDAOException("Failed to retrieve generated ID for the inserted teacher");
            }

            JOptionPane.showMessageDialog(null, "Teacher inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to insert a teacher: " + e.getMessage());
        }
        return teacher;
    }


    @Override
    public Teacher update(Teacher teacher) throws TeacherDAOException {
        String sql = "UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            int id = teacher.getId();
            String firstname = teacher.getFirstName();
            String lastname = teacher.getLastName();

            ps.setString(1,firstname);
            ps.setString(2,lastname);
            ps.setInt(3,id);

            int n = ps.executeUpdate();
            if(n !=1){
                return null;
            }

            JOptionPane.showMessageDialog(null, "Teacher updated successfully");
        }catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to update a teacher" + teacher);

        }
        return teacher;
    }

    @Override
    public void delete(Integer id) throws TeacherDAOException {
    String sql = "DELETE FROM TEACHERS WHERE ID = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,id);
            int n = ps.executeUpdate();
            if(n != 1){
                throw new TeacherDAOException("Teacher with id " + id + " was not found");
            }
            JOptionPane.showMessageDialog(null, "Teacher deleted successfully");
        }catch (SQLException e){
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to delete a teacher with id: " + id);
        }
    }

    @Override
    public Teacher getById(Integer id) throws TeacherDAOException {
        String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM TEACHERS WHERE ID = ?";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("ID"));
                teacher.setFirstName(rs.getString("FIRSTNAME"));
                teacher.setLastName(rs.getString("LASTNAME"));
                return teacher;
            }
            JOptionPane.showMessageDialog(null, "Teacher retrieved successfully");
        }catch (SQLException e){
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to retrieve a teacher with id " + id);
        }
        return null;
    }

    @Override
    public List<Teacher> getByLastname(String lastname) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps =connection.prepareStatement(sql)) {
            ps.setString(1, "%" + lastname + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("ID"));
                teacher.setFirstName(rs.getString("FIRSTNAME"));
                teacher.setLastName(rs.getString("LASTNAME"));
                teachers.add(teacher);
            }
//            JOptionPane.showMessageDialog(null, "Teacher retrieved successfully");
        }catch (SQLException e){
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to retrieve teachers with lastname " + lastname);
        }
        return teachers;

    }

    @Override
    public List<Teacher> getAll() throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("ID"));
                teacher.setFirstName(rs.getString("FIRSTNAME"));
                teacher.setLastName(rs.getString("LASTNAME"));
                teachers.add(teacher);
            }
            JOptionPane.showMessageDialog(null, "Teachers retrieved successfully");
        }catch (SQLException e){
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to retrieve all teachers");
        }
        return teachers;
    }

    @Override
    public List<Teacher> getByFirstname(String firstname) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE FIRSTNAME LIKE ?";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps =connection.prepareStatement(sql)) {
            ps.setString(1, "%" + firstname + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("ID"));
                teacher.setFirstName(rs.getString("FIRSTNAME"));
                teacher.setLastName(rs.getString("LASTNAME"));
                teachers.add(teacher);
            }
            JOptionPane.showMessageDialog(null, "Teacher retrieved successfully");
        }catch (SQLException e){
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to retrieve teachers with firstname " + firstname);
        }
        return teachers;
    }

    @Override
    public List<Teacher> getByLastnameAndFirstname(Integer id, String lastname, String firstname) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ? AND FIRSTNAME LIKE ?";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps =connection.prepareStatement(sql)) {
            ps.setString(1, "%" + lastname + "%");
            ps.setString(2, "%" + firstname + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("ID"));
                teacher.setFirstName(rs.getString("FIRSTNAME"));
                teacher.setLastName(rs.getString("LASTNAME"));
                teachers.add(teacher);
            }
            JOptionPane.showMessageDialog(null, "Teacher retrieved successfully");
        }catch (SQLException e){
            e.printStackTrace();
            throw new TeacherDAOException("An error occurred while trying to retrieve teachers with lastname " + lastname + " and firstname " + firstname);
        }
        return teachers;
    }
}
