package project.model.wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import project.model.wrapper.exceptions.CityDataCouldNotBeFoundException;
import project.model.wrapper.exceptions.WikipediaWrapperException;

public class CityDataHelper implements IWrapper {
    private String cityName;
    private String wikipediaFileName;
    private String dbcityFileName;
    
    private WikipediaWrapper wikipediaWrapper;
    
    public CityDataHelper(String cityName) {
        this.cityName = cityName;
        
        try {
            this.makeWikipediaRequest();
        } catch (IOException ex) {
            //this is fine
        }

//        Commented out since not yet working.
//        try {
//            this.makeDbcityRequest();
//        } catch (IOException ex) {
//            //this is fine
//        }

        this.wikipediaWrapper = new WikipediaWrapper(this.wikipediaFileName);
    }
    
    /**
     * Make request to Wikipedia with cityName as a query
     */
    private void makeWikipediaRequest() throws IOException {
        String link = "https://en.wikipedia.org/wiki/";
        
        this.wikipediaFileName = "wikipedia_" + this.cityName;
        
        HttpRequestHelper.httpRequest1(link, cityName, this.wikipediaFileName);
    }
    
    /**
     * Make request to DBCity with cityName as a query
     */
    private void makeDbcityRequest() throws IOException {
        String link = "https://en.db-city.com/";
        
        this.dbcityFileName = "dbcity_" + this.cityName;
        
        HttpRequestHelper.httpRequest1(link, cityName, this.dbcityFileName);
    }

    
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCountry() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isCapital() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCountryFlag() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getCountryLanguages() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getCityFlag() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getCityLandmarks() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getArea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getInhabitants() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getInhabitants();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new CityDataCouldNotBeFoundException();
    }

    @Override
    public float getPopulationDensity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPostalCode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMayorName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getLatitude() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getLongitude() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getAltitude() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getClimate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTimezone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWebsite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> getTwinTowns() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
