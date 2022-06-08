package project.model.wrapper;

import java.util.List;

import project.model.wrapper.exceptions.WrapperException;

/**
 * Interface specifying all required methods that each wrapper
 * has to implement.
 */
public interface IWrapper {

    /**
     * Finds and returns the name of the city.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getName() throws WrapperException;

    /**
     * Finds and returns the name of the country,
     * to which the city belongs.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getCountry() throws WrapperException;

    /**
     * Finds and returns boolean that represents
     * if the city is a capital of a country.
     * Throws Exception if data could not be found.
     *
     * @return boolean
     * @throws java.lang.WrapperException
     */
    public boolean isCapital() throws WrapperException;

    /**
     * Finds and returns the URL to the image with
     * flag of the country to which the city belongs.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getCountryFlag() throws WrapperException;

    /**
     * Finds and returns List of Strings representing every
     * official language spoken in the country to which
     * the city belongs.
     * Throws Exception if data could not be found.
     *
     * @return List
     * @throws java.lang.WrapperException
     */
    public List<String> getCountryLanguages() throws WrapperException;

    /**
     * Finds and returns the URL to the image with
     * flag of the city.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getCityFlag() throws WrapperException;

    /**
     * Finds and returns List of urls to images of City's landmarks.
     * Throws Exception if data could not be found.
     *
     * @return List
     * @throws java.lang.WrapperException
     */
    public List<String> getCityLandmarks() throws WrapperException;

    /**
     * Finds and returns area of the city in km^2.
     * Throws Exception if data could not be found.
     *
     * @return float
     * @throws java.lang.WrapperException
     */
    public float getArea() throws WrapperException;

    /**
     * Finds and returns number of inhabitants of the city.
     * Throws Exception if data could not be found.
     *
     * @return int
     * @throws java.lang.WrapperException
     */
    public int getInhabitants() throws WrapperException;

    /**
     * Finds and returns city's population density in
     * number of inhabitants per square kilometer.
     * Throws Exception if data could not be found.
     *
     * @return float
     * @throws java.lang.WrapperException
     */
    public float getPopulationDensity() throws WrapperException;

    /**
     * Finds and returns city's postal code.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getPostalCode() throws WrapperException;

    /**
     * Finds and returns name and surname of city's mayor.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getMayorName() throws WrapperException;

    /**
     * Finds and returns city's latitude.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getLatitude() throws WrapperException;

    /**
     * Finds and returns city's longitude.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getLongitude() throws WrapperException;

    /**
     * Finds and returns city's altitude (in meters).
     * Throws Exception if data could not be found.
     *
     * @return float
     * @throws java.lang.WrapperException
     */
    public float getAltitude() throws WrapperException;

    /**
     * Finds and returns city's climate information.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getClimate() throws WrapperException;

    /**
     * Finds and returns city's timezone.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getTimezone() throws WrapperException;

    /**
     * Finds and returns city's website.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getWebsite() throws WrapperException;

    /**
     * Finds and returns List of city's twin towns.
     * Throws Exception if data could not be found.
     *
     * @return List
     * @throws java.lang.WrapperException
     */
    public List<String> getTwinTowns() throws WrapperException;

    /**
     * Finds and returns city's demonym.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getDemonym() throws WrapperException;

    /**
     * Finds and returns city's phone number.
     * Throws Exception if data could not be found.
     *
     * @return String
     * @throws java.lang.WrapperException
     */
    public String getPhoneNumber() throws WrapperException;
}
