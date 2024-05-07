package filippos.tsakiris.scool_app_pro.dto.userdto;

import filippos.tsakiris.scool_app_pro.enums.Role;

public class UserReadOnlyDTO {
    private Integer id;
    private String username;
    private Role role;

    public UserReadOnlyDTO() {
    }

    public UserReadOnlyDTO(Integer id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
