package filippos.tsakiris.scool_app_pro.dto.userdto;

import filippos.tsakiris.scool_app_pro.enums.Role;

public class UserInsertDTO {
    private Integer id;
    private String username;
    private String password;
    private Role role;

    public UserInsertDTO() {
    }

    public UserInsertDTO(Integer id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserInsertDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
