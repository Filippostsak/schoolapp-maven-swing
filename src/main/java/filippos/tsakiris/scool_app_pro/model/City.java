package filippos.tsakiris.scool_app_pro.model;

/**
 * Represents a city entity within the school system. This class is used to track
 * cities that may be associated with various school events, locations, or personal addresses.
 */
public class City {
    private Integer id;
    private String city;

    /**
     * Default constructor for creating a new City instance without initializing fields.
     */
    public City() {
    }

    /**
     * Constructs a new City instance with specified details.
     *
     * @param id   the unique identifier for the city
     * @param city the name of the city
     */
    public City(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    /**
     * Retrieves the unique identifier of the city.
     *
     * @return the unique identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the city.
     *
     * @param id the unique identifier to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the city.
     *
     * @return the name of the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the name of the city.
     *
     * @param city the name of the city to be set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns a string representation of the City object, including its id and name.
     *
     * @return a string representation of the City object
     */
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
