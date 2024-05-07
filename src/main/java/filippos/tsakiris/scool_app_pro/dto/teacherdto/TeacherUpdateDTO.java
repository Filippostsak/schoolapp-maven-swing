package filippos.tsakiris.scool_app_pro.dto.teacherdto;

import filippos.tsakiris.scool_app_pro.enums.Gender;

import java.util.Date;

/**
 * Data Transfer Object (DTO) for updating teacher information.
 */
public class TeacherUpdateDTO {

    private Integer id;
    private String firstname;
    private String lastname;


    /**
     * Default constructor.
     */
    public TeacherUpdateDTO() {
    }

    /**
     * Constructor with parameters.
     *
     * @param id          The ID of the teacher.
     * @param firstname   The first name of the teacher.
     * @param lastname    The last name of the teacher.
     */
    public TeacherUpdateDTO(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Getter for ID.
     *
     * @return The ID of the teacher.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for ID.
     *
     * @param id The ID of the teacher.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for first name.
     *
     * @return The first name of the teacher.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Setter for first name.
     *
     * @param firstname The first name of the teacher.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Getter for last name.
     *
     * @return The last name of the teacher.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Setter for last name.
     *
     * @param lastname The last name of the teacher.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
