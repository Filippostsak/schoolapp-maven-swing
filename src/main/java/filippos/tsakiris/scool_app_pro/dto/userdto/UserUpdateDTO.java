package filippos.tsakiris.scool_app_pro.dto.userdto;

import filippos.tsakiris.scool_app_pro.enums.Role;

public class UserUpdateDTO {
    private Integer id;
    private String username;
    private String password;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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
}
