package filippos.tsakiris.scool_app_pro.model;

/**
 * Represents the specialty area of a teacher or an educational course within the school system.
 * This class is used to track the various areas of expertise or focus areas that are available or taught.
 */
public class Specialities {
    private Integer id;
    private String speciality;

    /**
     * Default constructor for creating a new Specialities instance without setting properties.
     */
    public Specialities() {
    }

    /**
     * Constructs a new Specialities instance with specified details.
     *
     * @param id         the unique identifier for the speciality
     * @param speciality the descriptive name of the speciality
     */
    public Specialities(Integer id, String speciality) {
        this.id = id;
        this.speciality = speciality;
    }

    /**
     * Retrieves the unique identifier of the speciality.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the speciality.
     *
     * @param id the unique identifier to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the speciality.
     *
     * @return the name of the speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Sets the name of the speciality.
     *
     * @param speciality the name of the speciality to be set
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * Returns a string representation of the Specialities object, including its id and name.
     *
     * @return a string representation of the Specialities object
     */
    @Override
    public String toString() {
        return "Specialities{" +
                "id=" + id +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
