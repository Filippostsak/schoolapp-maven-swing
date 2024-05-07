package filippos.tsakiris.scool_app_pro.service.user;

import filippos.tsakiris.scool_app_pro.dto.userdto.UserInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.userdto.UserUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.User;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserDeleteException;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserInsertException;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserUpdateException;

import java.util.List;

public interface IUserService {

    User insertUser(UserInsertDTO userInsertDTO) throws UserInsertException;
    User updateUser(UserUpdateDTO userUpdateDTO) throws UserUpdateException;
    void deleteUser(Integer id) throws UserDeleteException;
    User getUserById(Integer id);
    List<User> getUserByFirstName(String firstName);
    List<User> getUserByRole(String role);
}
