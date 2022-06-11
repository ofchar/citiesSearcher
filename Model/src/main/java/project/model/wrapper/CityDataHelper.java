package project.model.wrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import project.model.wrapper.exceptions.CityDataCouldNotBeFoundException;
import project.model.wrapper.exceptions.DbCityWrapperException;
import project.model.wrapper.exceptions.WikipediaWrapperException;

public class CityDataHelper implements IWrapper {
    private String cityName;
    private String countryName;
    private boolean strict;

    private WikipediaWrapper wikipediaWrapper;
    private DBCityWrapper dbcityWrapper;

    private void init() {
        try {
            this.wikipediaWrapper = new WikipediaWrapper(this.cityName, this.countryName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.dbcityWrapper = new DBCityWrapper(this.cityName, this.countryName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Constructor which defaults to strict mode, meaning that helper will throw
     * CityDataCouldNotBeFoundException exception if method could not find data.
     *
     * @param cityName
     * @param countryName
     */
    public CityDataHelper(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.strict = true;

        init();
    }

    /**
     * Constructor that gives possibility to create helper in non strict mode. If strict is set
     * to false method will return null or other defaults if it could not find the data.
     * @param cityName
     * @param countryName
     * @param strict
     */
    public CityDataHelper(String cityName, String countryName, boolean strict) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.strict = strict;

        init();
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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.isCapital();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
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
        try {
            return this.wikipediaWrapper.getCountryFlag();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getCountryFlag();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public List<String> getCountryLanguages() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getCountryLanguages();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getCountryLanguages();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getCityFlag();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getCityLandmarks();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getArea();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getInhabitants();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getPopulationDensity();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
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
            return this.dbcityWrapper.getPostalCode();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.wikipediaWrapper.getPostalCode();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
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
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getMayorName();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getLatitude() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getLatitude();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getLatitude();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getLongitude() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getLongitude();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getLongitude();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public float getAltitude() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getAltitude();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getAltitude();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return 0;
        }
    }

    @Override
    public String getClimate() throws CityDataCouldNotBeFoundException{
        try {
            return this.wikipediaWrapper.getClimate();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getClimate();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getTimezone() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getTimezone();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getTimezone();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public String getWebsite() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getWebsite();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getWebsite();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    @Override
    public List<String> getTwinTowns() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getTwinTowns();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        try {
            return this.dbcityWrapper.getTwinTowns();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return new ArrayList<String>();
        }
    }

    public String getDemonym() throws CityDataCouldNotBeFoundException {
        try {
            return this.wikipediaWrapper.getDemonym();
        } catch (WikipediaWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }

    public String getPhoneNumber() throws CityDataCouldNotBeFoundException {
        try {
            return this.dbcityWrapper.getPhoneNumber();
        } catch (DbCityWrapperException ex) {
            // Nothing for now.
        }

        if(strict) {
            throw new CityDataCouldNotBeFoundException();
        }
        else {
            return null;
        }
    }
}
