package filippos.tsakiris.scool_app_pro.dao.user;

import filippos.tsakiris.scool_app_pro.dao.exceptions.UserDAOException;
import filippos.tsakiris.scool_app_pro.enums.Role;
import filippos.tsakiris.scool_app_pro.model.User;
import filippos.tsakiris.scool_app_pro.service.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO{
    @Override
    public User insertUser(User user) throws UserDAOException {
       String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
       try{
              Connection connection = DBUtil.getConnection();
              PreparedStatement ps = connection.prepareStatement(sql);
              String username = user.getUsername();
              String password = user.getPassword();
              Role role = user.getRole();

              ps.setString(1, username);
              ps.setString(2, password);
              ps.setString(3, role.toString());

              int n = ps.executeUpdate();
              if(n != 1){
                return null;
              }
         } catch (SQLException e) {
              e.printStackTrace();
              throw new UserDAOException("An error occurred while trying to insert a user" + user);
       }
         return user;
    }

    @Override
    public User updateUser(User user) throws UserDAOException {
        String sql = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            int id = user.getId();
            String username = user.getUsername();
            String password = user.getPassword();
            Role role = user.getRole();

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role.toString());
            ps.setInt(4, id);

            int n = ps.executeUpdate();
            if(n != 1){
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDAOException("An error occurred while trying to update a user" + user);
        }
        return user;
    }

    @Override
    public void deleteUser(Integer id) throws UserDAOException {
    String sql = "DELETE FROM users WHERE id = ?";
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int n = ps.executeUpdate();
            if(n != 1){
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDAOException("An error occurred while trying to delete a user with id: " + id);
        }
    }

    @Override
    public User getUserById(Integer id) throws UserDAOException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(Role.valueOf(rs.getString("role")));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new UserDAOException("Error retrieving user with id: " + id);
        }
        return null;
    }


    @Override
    public List<User> getUserByUsername(String username) throws UserDAOException {
        String sql = "SELECT * FROM users WHERE username = ?";
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(Role.valueOf(rs.getString("role")));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new UserDAOException("Error retrieving user with username: " + username);
        }
        return users;
    }



    @Override
    public List<User> getUserByRole(String role) throws UserDAOException {
        String sql = "SELECT * FROM users WHERE role = ?";
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, role);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(Role.valueOf(rs.getString("role")));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new UserDAOException("Error retrieving users with role: " + role);
        }
        return users;
    }



}
