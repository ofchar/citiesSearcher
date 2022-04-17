package project.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.model.wrapper.CityDataHelper;
import project.model.wrapper.exceptions.CityDataCouldNotBeFoundException;

public class City {
    private String name;
    private String country;
    private boolean isCapital;
    private String countryFlag;
    private List languages;
    private String cityFlag;
    private List landmarks;
    private float area;
    private int inhabitants;
    private float populationDensity;
    private String postalCode;
    private String mayor;
    private float latitude;
    private float longitute;
    private float altitude;
    private String climate;
    private String timezone;
    private String website;
    private List twinCities;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
        
        fillData();
    }
    
    private void fillData() {
        CityDataHelper helper = new CityDataHelper(this.name);
        
        try {
            this.isCapital = helper.isCapital();
//            this.countryFlag
//            this.langauges
            this.landmarks = helper.getCityLandmarks();
            this.area = helper.getArea();
            this.inhabitants = helper.getInhabitants();
            this.populationDensity = helper.getPopulationDensity();
            this.postalCode = helper.getPostalCode();
            this.mayor = helper.getMayorName();
            //rest
        } catch (CityDataCouldNotBeFoundException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String toString() {
        return Float.toString(this.area);
    }
}
