package filippos.tsakiris.scool_app_pro.service.user;

import filippos.tsakiris.scool_app_pro.dao.exceptions.UserDAOException;
import filippos.tsakiris.scool_app_pro.dao.user.IUserDAO;
import filippos.tsakiris.scool_app_pro.dto.userdto.UserInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.userdto.UserUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.User;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserDeleteException;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserInsertException;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserUpdateException;

import java.util.List;

public class UserServiceImpl implements IUserService{

    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User insertUser(UserInsertDTO userInsertDTO) throws UserInsertException {
        if(userInsertDTO == null){
            throw new IllegalArgumentException("DTO cannot be null");
        }try {
            User user = map(userInsertDTO);
            return userDAO.insertUser(user);
        }catch (UserDAOException e){
            e.printStackTrace();
            throw new UserInsertException("An error occurred while trying to insert a user" + userInsertDTO);
        }
    }

    @Override
    public User updateUser(UserUpdateDTO userUpdateDTO) throws UserUpdateException {
     if(userUpdateDTO == null){
         throw new IllegalArgumentException("DTO cannot be null");
        }try {
            User user = map(userUpdateDTO);
            if(user.getId() == null){
                throw new UserUpdateException("User update failed.");
            }
            return userDAO.updateUser(user);
        }catch (UserDAOException e){
            e.printStackTrace();
            throw new UserUpdateException("An error occurred while trying to update a user" + userUpdateDTO);
        }
    }

    @Override
    public void deleteUser(Integer id) throws UserDeleteException {
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }try {
            userDAO.deleteUser(id);
        }catch (UserDAOException e){
            e.printStackTrace();
            throw new UserDeleteException("An error occurred while trying to delete a user with id: " + id);
        }

    }

    @Override
    public User getUserById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }try {
            return userDAO.getUserById(id);
        }catch (UserDAOException e){
            e.printStackTrace();
            throw new IllegalArgumentException("An error occurred while trying to get a user with id: " + id);
        }
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        try {
            return userDAO.getUserByUsername(firstName);
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("An error occurred while trying to get a user with first name: " + firstName);
        }
    }

    @Override
    public List<User> getUserByRole(String role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        try {
            return userDAO.getUserByRole(role);
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("An error occurred while trying to get a user with role: " + role);
        }
    }

    //Mappers

    public User map(UserInsertDTO dto){
       if(dto == null){
           throw new IllegalArgumentException("DTO cannot be null");
       }
       return new User(null,dto.getUsername(),dto.getPassword(),dto.getRole());
    }

    public User map(UserUpdateDTO dto){
        if(dto == null){
            throw new IllegalArgumentException("DTO cannot be null");
        }
        return new User(dto.getId(),dto.getUsername(),dto.getPassword());
    }
}
