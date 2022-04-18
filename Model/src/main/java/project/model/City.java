package project.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;
import project.model.wrapper.CityDataHelper;
import project.model.wrapper.exceptions.CityDataCouldNotBeFoundException;
import project.model.xmler.IXMLizable;

public class City implements IXMLizable{
    private String name;
    private String country;
    private boolean isCapital;
    private String countryFlag;
    private List<String> languages;
    private String cityFlag;
    private List<String> landmarks;
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
    private List<String> twinCities;

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
//            throw new Exception(ex);
        }
    }
    
    /**
     * Serialize City object to XML element for further use.
     * It will return root city element called "city", with every field as a child.
     * 
     * @return Element
     */
    public Element toXML() {
        Element city = new Element("city");

        Element officialLanguages = new Element("officialLanguages");
        for(String language : this.languages) {
            officialLanguages.addContent(new Element("language").setText(language));
        }

        Element landmarks = new Element("officialLanguages");
        for(String landmark : this.landmarks) {
            landmarks.addContent(new Element("landmark").setText(landmark));
        }

        Element twinCities = new Element("twinCities");
        for(String twinCity : this.twinCities) {
            twinCities.addContent(new Element("city").setText(twinCity));
        }
        
        
        city.addContent(new Element("name").setText(this.name));
        city.addContent(new Element("country").setText(this.country));
        city.addContent(new Element("isCapital").setText(this.isCapital ? "True" : "False"));
//        city.addContent(new Element("countryFlag").setText(this.countryFlag));
        city.addContent(officialLanguages);
        city.addContent(new Element("cityFlag").setText(this.cityFlag));
        city.addContent(landmarks);
        city.addContent(new Element("area").setText(Float.toString(this.area)).setAttribute("unit", "km2"));
        city.addContent(new Element("inhabitants").setText(Integer.toString(this.inhabitants)));
        city.addContent(new Element("populationDensity").setText(Float.toString(this.populationDensity)).setAttribute("unit", "people/km2"));
        city.addContent(new Element("postalCode").setText(this.postalCode));
        city.addContent(new Element("mayor").setText(this.mayor));
        city.addContent(new Element("latitude").setText(Float.toString(this.latitude)));
        city.addContent(new Element("longitute").setText(Float.toString(this.longitute)));
        city.addContent(new Element("altitude").setText(Float.toString(this.altitude)).setAttribute("unit", "m"));
        city.addContent(new Element("climate").setText(this.climate));
        city.addContent(new Element("timezone").setText(this.timezone));
        city.addContent(new Element("website").setText(this.website));
        
        return city;
    }
}
