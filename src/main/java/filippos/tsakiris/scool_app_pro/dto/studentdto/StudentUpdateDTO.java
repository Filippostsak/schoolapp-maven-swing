package filippos.tsakiris.scool_app_pro.dto.studentdto;

import filippos.tsakiris.scool_app_pro.enums.Gender;

import java.util.Date;

/**
 * Data Transfer Object (DTO) for representing the data needed to update a student.
 */
public class StudentUpdateDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;

    /**
     * Default constructor.
     */
    public StudentUpdateDTO() {
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
    public StudentUpdateDTO(Integer id, String firstName, String lastName, Gender gender, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter for ID.
     *
     * @return The ID of the student.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for ID.
     *
     * @param id The ID of the student.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for first name.
     *
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name.
     *
     * @param firstName The first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for last name.
     *
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name.
     *
     * @param lastName The last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for gender.
     *
     * @return The gender of the student.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Setter for gender.
     *
     * @param gender The gender of the student.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Getter for date of birth.
     *
     * @return The date of birth of the student.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter for date of birth.
     *
     * @param dateOfBirth The date of birth of the student.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
