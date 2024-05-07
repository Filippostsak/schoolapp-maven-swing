package filippos.tsakiris.scool_app_pro.dto.studentdto;

import filippos.tsakiris.scool_app_pro.enums.Gender;

import java.util.Date;

/**
 * Data Transfer Object (DTO) for representing a read-only view of a student.
 */
public class StudentReadOnlyDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;

    /**
     * Default constructor.
     */
    public StudentReadOnlyDTO() {
    }

    /**
     * Constructor with parameters.
     *
     * @param id          The ID of the student.
     * @param firstName   The first name of the student.
     * @param lastName    The last name of the student.
     * @param gender      The gender of the student.
     * @param dateOfBirth The date of birth of the student.
     */
    public StudentReadOnlyDTO(Integer id, String firstName, String lastName, Gender gender, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the ID of the student.
     *
     * @return The ID of the student.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     *
     * @param id The ID of the student.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName The first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName The last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the gender of the student.
     *
     * @return The gender of the student.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the student.
     *
     * @param gender The gender of the student.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Retrieves the date of birth of the student.
     *
     * @return The date of birth of the student.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the student.
     *
     * @param dateOfBirth The date of birth of the student.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
