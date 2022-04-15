package project.model.wrapper;

import java.util.List;

/**
 * Interface specifying all required methods that each wrapper
 * has to implement.
 */
public interface IWrapper {
    
    /**
     * Finds and returns the name of the city.
     * 
     * @return String
     */
    public String getName();
    
    /**
     * Finds and returns the name of the country,
     * to which the city belongs.
     * 
     * @return String
     */
    public String getCountry();
    
    /**
     * Finds and returns boolean that represents
     * if the city is a capital of a country.
     * 
     * @return boolean
     */
    public boolean isCapital();
    
    /**
     * Finds and returns the URL to the image with
     * flag of the country to which the city belongs.
     * 
     * @return String
     */
    public String getCountryFlag();
    
    /**
     * Finds and returns List of Strings representing every
     * official language spoken in the country to which 
     * the city belongs.
     * 
     * @return List
     */
    public List<String> getCountryLanguages();
    
    /**
     * Finds and returns the URL to the image with
     * flag of the city.
     * 
     * @return String
     */
    public String getCityFlag();
    
    /**
     * Finds and returns List of urls to images of City's landmarks.
     * 
     * @return List
     */
    public List<String> getCityLandmarks();
    
    /**
     * Finds and returns area of the city in km^2.
     * 
     * @return float
     */
    public float getArea();

    /**
     * Finds and returns number of inhabitants of the city.
     * 
     * @return int
     */
    public int getInhabitants();

    /**
     * Finds and returns city's population density in
     * number of inhabitants per square kilometer.
     * 
     * @return float
     */
    public float getPopulationDensity();
    
    /**
     * Finds and returns city's postal code.
     * 
     * @return String
     */
    public String getPostalCode();
      
    /**
     * Finds and returns name and surname of city's mayor.
     * 
     * @return String
     */
    public String getMayorName();
    
    /**
     * Finds and returns city's latitude.
     * 
     * @return float
     */
    public float getLatitude();
    
    /**
     * Finds and returns city's longitude.
     * 
     * @return float
     */
    public float getLongitude();
    
    /**
     * Finds and returns city's altitude (in meters).
     * 
     * @return float
     */
    public float getAltitude();
    
    /**
     * Finds and returns city's climate information.
     * 
     * @return String
     */
    public String getClimate();
    
    /**
     * Finds and returns city's timezone.
     * 
     * @return String
     */
    public String getTimezone();
    
    /**
     * Finds and returns city's website.
     * 
     * @return String
     */
    public String getWebsite();
    
    /**
     * Finds and returns List of city's twin towns.
     * 
     * @return List
     */
    public List<String> getTwinTowns();
}
