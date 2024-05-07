package filippos.tsakiris.scool_app_pro.service.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import filippos.tsakiris.scool_app_pro.dao.user.IUserDAO;
import filippos.tsakiris.scool_app_pro.dto.userdto.UserInsertDTO;
import filippos.tsakiris.scool_app_pro.dto.userdto.UserUpdateDTO;
import filippos.tsakiris.scool_app_pro.model.User;
import filippos.tsakiris.scool_app_pro.enums.Role;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserDeleteException;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserInsertException;
import filippos.tsakiris.scool_app_pro.service.user.exceptions.UserUpdateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    IUserDAO userDAOMock;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void insertUser_whenDtoIsValid_expectUserReturned() throws Exception {
        UserInsertDTO dto = new UserInsertDTO("username", "password", "Student");
        User expectedUser = new User(null, "username", "password", Role.Student);
        when(userDAOMock.insertUser(any(User.class))).thenReturn(expectedUser);

        User result = userService.insertUser(dto);

        assertEquals(expectedUser, result);
        verify(userDAOMock).insertUser(any(User.class));
    }

    @Test
    void insertUser_whenDtoIsNull_expectException() {
        assertThrows(IllegalArgumentException.class, () -> userService.insertUser(null));
    }

    @Test
    void updateUser_whenDtoIsValid_expectUserUpdated() throws Exception {
        UserUpdateDTO dto = new UserUpdateDTO(1, "username", "password");
        User expectedUser = new User(1, "username", "password", Role.Teacher); // Assume role is Teacher for updates
        when(userDAOMock.updateUser(any(User.class))).thenReturn(expectedUser);

        User result = userService.updateUser(dto);

        assertEquals(expectedUser, result);
        verify(userDAOMock).updateUser(any(User.class));
    }

    @Test
    void updateUser_whenDtoIsNull_expectException() {
        assertThrows(IllegalArgumentException.class, () -> userService.updateUser(null));
    }

    @Test
    void deleteUser_whenIdIsValid_expectNoException() throws Exception {
        doNothing().when(userDAOMock).deleteUser(1);

        assertDoesNotThrow(() -> userService.deleteUser(1));
        verify(userDAOMock).deleteUser(1);
    }

    @Test
    void deleteUser_whenIdIsNull_expectException() {
        assertThrows(IllegalArgumentException.class, () -> userService.deleteUser(null));
    }

    @Test
    void getUserById_whenIdIsValid_expectUserReturned() throws Exception {
        User expectedUser = new User(1, "username", "password", Role.Student);
        when(userDAOMock.getUserById(1)).thenReturn(expectedUser);

        User result = userService.getUserById(1);

        assertEquals(expectedUser, result);
        verify(userDAOMock).getUserById(1);
    }

    @Test
    void getUserById_whenIdIsNull_expectException() {
        assertThrows(IllegalArgumentException.class, () -> userService.getUserById(null));
    }

    @Test
    void getUserByFirstName_whenNameIsValid_expectUserListReturned() throws Exception {
        List<User> expectedUsers = Arrays.asList(new User(1, "username", "password", Role.Student));
        when(userDAOMock.getUserByUsername("username")).thenReturn(expectedUsers);

        List<User> result = userService.getUserByFirstName("username");

        assertEquals(expectedUsers, result);
        verify(userDAOMock).getUserByUsername("username");
    }

    @Test
    void getUserByFirstName_whenNameIsNull_expectException() {
        assertThrows(IllegalArgumentException.class, () -> userService.getUserByFirstName(null));
    }

    @Test
    void getUserByRole_whenRoleIsValid_expectUserListReturned() throws Exception {
        List<User> expectedUsers = Arrays.asList(new User(1, "username", "password", Role.Teacher));
        when(userDAOMock.getUserByRole("Teacher")).thenReturn(expectedUsers);

        List<User> result = userService.getUserByRole("Teacher");

        assertEquals(expectedUsers, result);
        verify(userDAOMock).getUserByRole("Teacher");
    }

    @Test
    void getUserByRole_whenRoleIsNull_expectException() {
        assertThrows(IllegalArgumentException.class, () -> userService.getUserByRole(null));
    }
}
