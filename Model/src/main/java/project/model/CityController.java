package project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;

import project.model.exceptions.ModelException;
import project.model.wrapper.CityDataHelper;
import project.model.xmler.XMLHelper;
import project.model.xmler.exceptions.XMLFileHelperException;
import project.model.xmler.exceptions.XMLHelperDocumentNotExistsException;
import project.model.xmler.exceptions.XMLHelperException;
import project.model.xmler.exceptions.XMLerException;
import project.model.xmler.templater.CityDocumentTemplater;

public class CityController {
    private XMLHelper xmlHelper;

    public CityController() throws Exception {
        xmlHelper = new XMLHelper("..\\resources\\cities.xml");

        //Lets try to read the document
        try {
            xmlHelper.readDocument();
        } catch (XMLFileHelperException ex) {
            //If we can't we should communicate that to user,
            //however, we will just try to create new one. For now. Or forever.
            try {
                xmlHelper.createDocument(new CityDocumentTemplater());
            } catch (XMLFileHelperException ex1) {
                throw new Exception(ex);
            }
        }
    }


    private boolean checkCityExistence(String name) throws XMLHelperDocumentNotExistsException {
        return xmlHelper.checkElementExistence("cities", "city", "name", name);
    }



    /**
     * CRUD methods
     * @throws Exception
     */

    /**
     * Get List of all cities stored in file.
     *
     * @return List
     * @throws Exception
     */
    public List<City> index() throws Exception{
            List<Element> elements = null;

            try {
                elements = xmlHelper.getAll("cities");
            } catch (XMLHelperDocumentNotExistsException e) {
                throw new ModelException("XML file not loaded", e);
            }

            List<City> cities = new ArrayList<City>();

            elements.forEach((element) -> cities.add(new City(element)));

            return cities;
    }

    /**
     * Get city from file by city name.
     * Method assumes that there must be no more than one city with same name.
     *
     * @param name
     * @return City
     * @throws ModelException
     */
    public City get(String name) throws ModelException {
        List<Element> elements;

        try {
            elements = xmlHelper.findElements("cities", "city", "name", name);
        } catch (XMLHelperDocumentNotExistsException e) {
            throw new ModelException("XML file not loaded", e);
        }

        if(elements.isEmpty()) {
            throw new ModelException("404");
        }

        return new City(elements.get(0));
    }

    public void create(String name, String country) throws ModelException {
        try {
            if(checkCityExistence(name)) {
                throw new ModelException("City already exist");
            }

            City newCity = new City(new CityDataHelper(name, country, false));

            xmlHelper.addToDocument("cities", newCity.toXML());

            xmlHelper.save();
        }
        catch (XMLHelperDocumentNotExistsException e) {
            throw new ModelException("XML file not loaded", e);
        }
        catch (XMLFileHelperException e) {
            throw new ModelException("Could not save modified XML file", e);
        }

    }

    public void update(String name, String elementToChange, String newValue) throws ModelException {
        try {
            xmlHelper.update("cities", "city", "name", name, elementToChange, newValue);

            xmlHelper.save();
        }
        catch (XMLHelperDocumentNotExistsException e) {
            throw new ModelException("XML file not loaded", e);
        }
        catch (XMLFileHelperException e) {
            throw new ModelException("Could not save modified XML file", e);
        }
        catch (XMLerException e) {
            throw new ModelException("Could not perform update", e);
        }
    }
    
    public void delete(String name) throws ModelException {
        try {
            xmlHelper.deleteParentOfElement("cities", "city", "name", name);
            
            xmlHelper.save();
        } catch (XMLerException e) {
            throw new ModelException("Could not perform deletion", e);
        }
    }



    /**
     * XPATH searches methods
     */

    private List<City> getCitiesByXpath(String xpath) throws ModelException {
        List<Element> elements;

        try {
            elements = xmlHelper.getXpath(xpath);
        } catch (XMLHelperDocumentNotExistsException e) {
            throw new ModelException("XML file not loaded", e);
        }

        List<City> cities = new ArrayList<City>();

        elements.forEach((element) -> cities.add(new City(element)));

        return cities;
    }

    public List<City> getCitiesByName(String name) throws ModelException {
        return getCitiesByXpath("//city[name = '" + name + "']");
    }

    public List<City> getCitiesOfCountry(String country) throws ModelException {
        return getCitiesByXpath("//city[country = '" + country + "']");
    }

    public List<City> getCitiesByMinPopulation(int minPopulation) throws ModelException {
        return getCitiesByXpath("//city[inhabitants/text() > " + minPopulation + "]");
    }

    public List<City> getCitiesByClimate(String climate) throws ModelException {
        return getCitiesByXpath("//city[climate = '" + climate + "']");
    }

    public List<City> getCapitals() throws ModelException {
        return getCitiesByXpath("//city[isCapital/text() = 'True']");
    }



    /**
     * VALIDATIONS
     */

    public boolean validateXsd() throws Exception {
        return xmlHelper.validateXsd();
    }

    public boolean validateDtd() throws Exception {
        return xmlHelper.validateDtd();
    }

    public boolean validateDocument() throws Exception {
        return validateDtd() && validateXsd();
    }



    /**
     * Transformations
     */

    public void transform() {
        try {
            xmlHelper.transform("./resources/transformation/test.xsl", "test.html");
        } catch (XMLHelperException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
