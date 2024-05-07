package filippos.tsakiris.scool_app_pro.model;

import filippos.tsakiris.scool_app_pro.enums.Gender;
import java.util.Date;

/**
 * Represents a student in the school application system. This entity stores
 * personal details about a student including their name, gender, and date of birth.
 */
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;

    /**
     * Default constructor for creating a new instance of Student without setting properties.
     */
    public Student() {
    }

    /**
     * Constructs a new Student with specified personal details.
     *
     * @param id           the unique identifier for the student
     * @param firstName    the first name of the student
     * @param lastName     the last name of the student
     * @param gender       the gender of the student
     * @param dateOfBirth  the date of birth of the student
     */
    public Student(Integer id, String firstName, String lastName, Gender gender, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the unique identifier of the student.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the student.
     *
     * @param id the unique identifier to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the student.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the student.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the gender of the student.
     *
     * @return the gender of the student
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the student.
     *
     * @param gender the gender to be set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Retrieves the date of birth of the student.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the student.
     *
     * @param dateOfBirth the date of birth to be set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns a string representation of the Student object, which includes their
     * id, first name, last name, gender, and date of birth.
     *
     * @return a string representation of the Student object
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
