package project.model.wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
    private String countryName;
    private String wikipediaFileName;
    private String dbcityFileName;
    private boolean strict;
    
    private WikipediaWrapper wikipediaWrapper;
    
    private void init() {       
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
    
    public CityDataHelper(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.strict = true;
        
        init();
    }
    
    public CityDataHelper(String cityName, String countryName, boolean strict) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.strict = strict;
        
        init();
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
        return this.cityName;
    }

    @Override
    public String getCountry() {
        return this.countryName;
    }

    @Override
    public boolean isCapital() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.isCapital();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return false;
        }
    }

    @Override
    public String getCountryFlag() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public List<String> getCountryLanguages() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return new ArrayList<String>();
        }
    }

    @Override
    public String getCityFlag() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getCityFlag();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public List<String> getCityLandmarks() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getCityLandmarks();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return new ArrayList<String>();
        }
    }

    @Override
    public float getArea() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getArea();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return -1;
        }
    }

    @Override
    public int getInhabitants() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getInhabitants();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return -1;
        }
    }

    @Override
    public float getPopulationDensity() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getPopulationDensity();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return -1;
        }
    }

    @Override
    public String getPostalCode() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getPostalCode();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getMayorName() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getMayorName();
        } catch (WikipediaWrapperException ex) {
            Logger.getLogger(CityDataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public float getLatitude() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return 0;
        }
    }

    @Override
    public float getLongitude() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return 0;
        }
    }

    @Override
    public float getAltitude() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return 0;
        }
    }

    @Override
    public String getClimate() throws CityDataCouldNotBeFoundException{
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getTimezone() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getWebsite() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public List<String> getTwinTowns() throws CityDataCouldNotBeFoundException {
        //Logic
        
        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return new ArrayList<String>();
        }
    }
}
