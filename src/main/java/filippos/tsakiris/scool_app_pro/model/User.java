package filippos.tsakiris.scool_app_pro.model;

import filippos.tsakiris.scool_app_pro.enums.Role;

/**
 * Represents a user in the school application system. A user can have different roles
 * which define their access and capabilities within the system.
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Role role;

    /**
     * Constructs a new User with no initial details.
     */
    public User() {
    }

    /**
     * Constructs a new User with specified details.
     *
     * @param id        the unique identifier for the user
     * @param username  the user's username
     * @param password  the user's password
     * @param role      the role of the user within the system
     */
    public User(Integer id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    /**
     * Gets the unique identifier for this user.
     *
     * @return the unique identifier for the user
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this user.
     *
     * @param id  the unique identifier for the user
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the username of this user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for this user.
     *
     * @param username  the new username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of this user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this user.
     *
     * @param password  the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of this user within the system.
     *
     * @return the role of the user
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role for this user within the system.
     *
     * @param role  the new role of the user
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Returns a string representation of the User object, which includes id, username, and role.
     *
     * @return a string representation of the user details
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='[PROTECTED]'" +
                ", role=" + role +
                '}';
    }
}
