package project.model.wrapper;

import java.util.List;

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
     * @throws java.lang.Exception
     */
    public String getName() throws Exception;
    
    /**
     * Finds and returns the name of the country,
     * to which the city belongs.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getCountry() throws Exception;
    
    /**
     * Finds and returns boolean that represents
     * if the city is a capital of a country.
     * Throws Exception if data could not be found.
     * 
     * @return boolean
     * @throws java.lang.Exception
     */
    public boolean isCapital() throws Exception;
    
    /**
     * Finds and returns the URL to the image with
     * flag of the country to which the city belongs.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getCountryFlag() throws Exception;
    
    /**
     * Finds and returns List of Strings representing every
     * official language spoken in the country to which 
     * the city belongs.
     * Throws Exception if data could not be found.
     * 
     * @return List
     * @throws java.lang.Exception
     */
    public List<String> getCountryLanguages() throws Exception;
    
    /**
     * Finds and returns the URL to the image with
     * flag of the city.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getCityFlag() throws Exception;
    
    /**
     * Finds and returns List of urls to images of City's landmarks.
     * Throws Exception if data could not be found.
     * 
     * @return List
     * @throws java.lang.Exception
     */
    public List<String> getCityLandmarks() throws Exception;
    
    /**
     * Finds and returns area of the city in km^2.
     * Throws Exception if data could not be found.
     * 
     * @return float
     * @throws java.lang.Exception
     */
    public float getArea() throws Exception;

    /**
     * Finds and returns number of inhabitants of the city.
     * Throws Exception if data could not be found.
     * 
     * @return int
     * @throws java.lang.Exception
     */
    public int getInhabitants() throws Exception;

    /**
     * Finds and returns city's population density in
     * number of inhabitants per square kilometer.
     * Throws Exception if data could not be found.
     * 
     * @return float
     * @throws java.lang.Exception
     */
    public float getPopulationDensity() throws Exception;
    
    /**
     * Finds and returns city's postal code.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getPostalCode() throws Exception;
      
    /**
     * Finds and returns name and surname of city's mayor.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getMayorName() throws Exception;
    
    /**
     * Finds and returns city's latitude.
     * Throws Exception if data could not be found.
     * 
     * @return float
     * @throws java.lang.Exception
     */
    public float getLatitude() throws Exception;
    
    /**
     * Finds and returns city's longitude.
     * Throws Exception if data could not be found.
     * 
     * @return float
     * @throws java.lang.Exception
     */
    public float getLongitude() throws Exception;
    
    /**
     * Finds and returns city's altitude (in meters).
     * Throws Exception if data could not be found.
     * 
     * @return float
     * @throws java.lang.Exception
     */
    public float getAltitude() throws Exception;
    
    /**
     * Finds and returns city's climate information.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getClimate() throws Exception;
    
    /**
     * Finds and returns city's timezone.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getTimezone() throws Exception;
    
    /**
     * Finds and returns city's website.
     * Throws Exception if data could not be found.
     * 
     * @return String
     * @throws java.lang.Exception
     */
    public String getWebsite() throws Exception;
    
    /**
     * Finds and returns List of city's twin towns.
     * Throws Exception if data could not be found.
     * 
     * @return List
     * @throws java.lang.Exception
     */
    public List<String> getTwinTowns() throws Exception;
}
