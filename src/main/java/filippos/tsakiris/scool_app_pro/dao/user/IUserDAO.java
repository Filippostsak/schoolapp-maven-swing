package filippos.tsakiris.scool_app_pro.dao.user;

import filippos.tsakiris.scool_app_pro.dao.exceptions.UserDAOException;
import filippos.tsakiris.scool_app_pro.model.User;

import java.util.List;

public interface IUserDAO {

    User insertUser(User user) throws UserDAOException;

    //update a user
    User updateUser(User user) throws UserDAOException;

    //delete a user
    void deleteUser(Integer id) throws UserDAOException;

    //find a user by id
    User getUserById(Integer id) throws UserDAOException;

    //find a user by username
    List<User> getUserByUsername(String username) throws UserDAOException;

    List<User> getUserByRole(String role) throws UserDAOException;

}
