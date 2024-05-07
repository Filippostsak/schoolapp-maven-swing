package filippos.tsakiris.scool_app_pro.model;

/**
 * Represents a teacher within the school application system. This entity holds
 * information about a teacher's identity and professional details.
 */
public class Teacher {
    private Integer id;
    private String firstName;
    private String lastName;

    /**
     * Default constructor for creating a new instance of Teacher without setting properties.
     */
    public Teacher() {
    }

    /**
     * Constructs a new Teacher with specified name details. This constructor
     * is typically used when creating a Teacher where the SSN is not yet known or not required.
     *
     * @param id        the unique identifier for the teacher
     * @param firstName the first name of the teacher
     * @param lastName  the last name of the teacher
     */
    public Teacher(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructs a new Teacher with full identity and professional details.
     *
     * @param id        the unique identifier for the teacher
     * @param firstName the first name of the teacher
     * @param lastName  the last name of the teacher
     */
    public Teacher(Integer id, String firstName, String lastName, int ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the unique identifier of the teacher.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the teacher.
     *
     * @param id the unique identifier to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the teacher.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the teacher.
     *
     * @param firstName the first name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the teacher.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the teacher.
     *
     * @param lastName the last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a string representation of the Teacher object, including their
     * id, first name, last name, and social security number.
     *
     * @return a string representation of the Teacher object
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
