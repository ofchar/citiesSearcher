package project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;
import project.model.wrapper.IWrapper;
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
    private String latitude;
    private String longitute;
    private float altitude;
    private String climate;
    private String timezone;
    private String website;
    private List<String> twinCities;

    public City(Element element) {
        fillData(element);
    }

    public City(IWrapper dataWrapper) {
        fillData(dataWrapper);
    }

    public City() {}

    public void fillData(IWrapper dataWrapper) {
        try {
            this.name = dataWrapper.getName();
            this.country = dataWrapper.getCountry();
            this.isCapital = dataWrapper.isCapital();
            this.countryFlag = dataWrapper.getCountryFlag();
            this.languages = dataWrapper.getCountryLanguages();
            this.landmarks = dataWrapper.getCityLandmarks();
            this.area = dataWrapper.getArea();
            this.inhabitants = dataWrapper.getInhabitants();
            this.populationDensity = dataWrapper.getPopulationDensity();
            this.postalCode = dataWrapper.getPostalCode();
            this.mayor = dataWrapper.getMayorName();
            this.latitude = dataWrapper.getLatitude();
            this.longitute = dataWrapper.getLongitude();
            this.altitude = dataWrapper.getAltitude();
            this.climate = dataWrapper.getClimate();
            this.timezone = dataWrapper.getTimezone();
            this.website = dataWrapper.getWebsite();
            this.twinCities = dataWrapper.getTwinTowns();
        } catch (CityDataCouldNotBeFoundException ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex);
        } catch (Exception ex) {
            Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
//            throw new Exception(ex);
        }
    }

    public void fillData(Element xmlCityElement) {
        this.name = xmlCityElement.getChildText("name");
        this.country = xmlCityElement.getChildText("country");
        this.isCapital = xmlCityElement.getChildText("isCapital").equals("True");
        this.countryFlag = xmlCityElement.getChildText("countryFlag");
        this.languages = new ArrayList<String>();
        this.landmarks = new ArrayList<String>();
        this.area = Float.parseFloat(xmlCityElement.getChildText("area"));
        this.inhabitants = Integer.parseInt(xmlCityElement.getChildText("inhabitants"));
        this.populationDensity = Float.parseFloat(xmlCityElement.getChildText("populationDensity"));
        this.postalCode = xmlCityElement.getChildText("postalCode");
        this.mayor = xmlCityElement.getChildText("mayor");
        this.latitude = xmlCityElement.getChildText("latitude");
        this.longitute = xmlCityElement.getChildText("longitute");
        this.altitude = Float.parseFloat(xmlCityElement.getChildText("altitude"));
        this.climate = xmlCityElement.getChildText("climate");
        this.timezone = xmlCityElement.getChildText("timezone");
        this.website = xmlCityElement.getChildText("website");
        this.twinCities = new ArrayList<String>();
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

        Element landmarks = new Element("landmarks");
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
        city.addContent(new Element("countryFlag").setText(this.countryFlag));
        city.addContent(officialLanguages);
        city.addContent(new Element("cityFlag").setText(this.cityFlag));
        city.addContent(landmarks);
        city.addContent(new Element("area").setText(Float.toString(this.area)).setAttribute("unit", "km2"));
        city.addContent(new Element("inhabitants").setText(Integer.toString(this.inhabitants)));
        city.addContent(new Element("populationDensity").setText(Float.toString(this.populationDensity)).setAttribute("unit", "people/km2"));
        city.addContent(new Element("postalCode").setText(this.postalCode));
        city.addContent(new Element("mayor").setText(this.mayor));
        city.addContent(new Element("latitude").setText(this.latitude));
        city.addContent(new Element("longitute").setText(this.longitute));
        city.addContent(new Element("altitude").setText(Float.toString(this.altitude)).setAttribute("unit", "m"));
        city.addContent(new Element("climate").setText(this.climate));
        city.addContent(new Element("timezone").setText(this.timezone));
        city.addContent(new Element("website").setText(this.website));

        return city;
    }
}
