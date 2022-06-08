package project.model;

import java.util.ArrayList;
import java.util.List;
import org.jdom2.Element;

import project.model.exceptions.ModelException;
import project.model.wrapper.IWrapper;
import project.model.wrapper.exceptions.WrapperException;
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
    private String longitude;
    private float altitude;
    private String climate;
    private String timezone;
    private String website;
    private List<String> twinCities;
    private String demonym;
    private String phoneNumber;

    public City(Element element) {
        fillData(element);
    }

    public City(IWrapper dataWrapper) throws ModelException {
        fillData(dataWrapper);
    }

    public City() {}


    /**
     * Fill fields of the class based on data from provided dataWrapper
     *
     * @param dataWrapper
     * @throws ModelException
     */
    public void fillData(IWrapper dataWrapper) throws ModelException {
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
            this.longitude = dataWrapper.getLongitude();
            this.altitude = dataWrapper.getAltitude();
            this.climate = dataWrapper.getClimate();
            this.timezone = dataWrapper.getTimezone();
            this.website = dataWrapper.getWebsite();
            this.twinCities = dataWrapper.getTwinTowns();
            this.demonym = dataWrapper.getDemonym();
            this.phoneNumber = dataWrapper.getPhoneNumber();
        }
        catch (WrapperException ex) {
            throw new ModelException("Could not create a city, missing data", ex);
        }
    }

    /**
     * Fill fields of the class based on cityElement from xml file
     *
     * @param xmlCityElement
     */
    public void fillData(Element xmlCityElement) {
        this.name = xmlCityElement.getChildText("name");
        this.country = xmlCityElement.getChildText("country");
        this.isCapital = xmlCityElement.getChildText("isCapital").equals("true");
        this.countryFlag = xmlCityElement.getChildText("countryFlag");
        this.area = Float.parseFloat(xmlCityElement.getChildText("area"));
        this.inhabitants = Integer.parseInt(xmlCityElement.getChildText("inhabitants"));
        this.populationDensity = Float.parseFloat(xmlCityElement.getChildText("populationDensity"));
        this.postalCode = xmlCityElement.getChildText("postalCode");
        this.mayor = xmlCityElement.getChildText("mayor");
        this.latitude = xmlCityElement.getChildText("latitude");
        this.longitude = xmlCityElement.getChildText("longitude");
        this.altitude = Float.parseFloat(xmlCityElement.getChildText("altitude"));
        this.climate = xmlCityElement.getChildText("climate");
        this.timezone = xmlCityElement.getChildText("timezone");
        this.website = xmlCityElement.getChildText("website");
        this.demonym = xmlCityElement.getChildText("demonym");
        this.phoneNumber = xmlCityElement.getChildText("phoneNumber");



        this.languages = new ArrayList<String>();
        Element languagesElement = xmlCityElement.getChild("officialLanguages");
        languagesElement.getChildren().forEach((language) -> this.languages.add(language.getText()));

        this.landmarks = new ArrayList<String>();
        Element landmarksElement = xmlCityElement.getChild("landmarks");
        landmarksElement.getChildren().forEach((landmark) -> this.landmarks.add(landmark.getText()));

        this.twinCities = new ArrayList<String>();
        Element twinCitiesElement = xmlCityElement.getChild("twinCities");
        twinCitiesElement.getChildren().forEach((city) -> this.twinCities.add(city.getText()));
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
            twinCities.addContent(new Element("twinCity").setText(twinCity));
        }


        city.addContent(new Element("name").setText(this.name));
        city.addContent(new Element("country").setText(this.country));
        city.addContent(new Element("isCapital").setText(this.isCapital ? "true" : "false"));
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
        city.addContent(new Element("longitude").setText(this.longitude));
        city.addContent(new Element("altitude").setText(Float.toString(this.altitude)).setAttribute("unit", "m"));
        city.addContent(new Element("climate").setText(this.climate));
        city.addContent(new Element("timezone").setText(this.timezone));
        city.addContent(new Element("website").setText(this.website));
        city.addContent(twinCities);
        city.addContent(new Element("demonym").setText(this.demonym));
        city.addContent(new Element("phoneNumber").setText(this.phoneNumber));

        return city;
    }



    /**
     * Getters :)
     */

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public String getCityFlag() {
        return cityFlag;
    }

    public List<String> getLandmarks() {
        return landmarks;
    }

    public float getArea() {
        return area;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public float getPopulationDensity() {
        return populationDensity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getMayor() {
        return mayor;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public String getClimate() {
        return climate;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getWebsite() {
        return website;
    }

    public List<String> getTwinCities() {
        return twinCities;
    }

    public String getDemonym() {
        return demonym;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
