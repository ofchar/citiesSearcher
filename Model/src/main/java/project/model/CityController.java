package project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;
import project.model.wrapper.CityDataHelper;
import project.model.xmler.XMLHelper;
import project.model.xmler.exceptions.XMLFileHelperException;
import project.model.xmler.exceptions.XMLHelperDocumentNotExistsException;
import project.model.xmler.exceptions.XMLerException;
import project.model.xmler.templater.CityDocumentTemplater;

public class CityController {
    private XMLHelper xmlHelper;

    public CityController() throws Exception {
        xmlHelper = new XMLHelper("cities.xml");

        //Lets try to read the document
        try {
            xmlHelper.readDocument();
        } catch (XMLFileHelperException ex) {
            //If we can't we should communicate that to user,
            //however, we will just try to create new one. For now. Or forever.
            try {
                xmlHelper.createDocument(new CityDocumentTemplater());
            } catch (XMLFileHelperException ex1) {
                throw new Exception(ex1);
            }
        }
    }


    private boolean checkCityExistence(String name) throws XMLHelperDocumentNotExistsException {
        return xmlHelper.checkElementExistence("cities", "city", "name", name);
    }



    public List<City> index() throws Exception {
        try {
            List<Element> elements = xmlHelper.getAll("cities");
            List<City> cities = new ArrayList<City>();

            for(Element element : elements) {
                cities.add(new City(element));
            }

            return cities;
        } catch (XMLHelperDocumentNotExistsException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("asdf");
        }
    }

    public Element get(String name) throws Exception {
        try {
            List<Element> elements = xmlHelper.findElements("cities", "city", "name", name);

            if(elements.isEmpty()) {
                throw new Exception("404");
            }

            //There *SHOULD* be just one element inside.
            return elements.get(0);
        } catch (XMLHelperDocumentNotExistsException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("sfsdfsd");
        }
    }

    public void create(String name, String country) throws Exception {
        try {
            if(checkCityExistence(name)) {
                throw new Exception("Already exist");
            }

            City newCity = new City(new CityDataHelper(name, country, false));

            xmlHelper.addToDocument("cities", newCity.toXML());

            xmlHelper.save();

        } catch (XMLHelperDocumentNotExistsException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(String name, Map<String, String> changes) {
        try {
            for (String key : changes.keySet()) {
                xmlHelper.update("cities", "city", "name", name, key, changes.get(key));
            }

            xmlHelper.save();
        }
        catch (XMLHelperDocumentNotExistsException ex) {
            //
        } catch (XMLerException ex) {
            //
        }
    }


    //searches by xpath below
    public List<City> getCitiesByName(String name) throws Exception {
        try {
            List<Element> elements = xmlHelper.getXpath("//city[name = '" + name + "']");
            List<City> cities = new ArrayList<City>();

            for(Element element : elements) {
                cities.add(new City(element));
            }

            return cities;
        } catch (XMLHelperDocumentNotExistsException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("asdf");
        }
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
        return xmlHelper.validate();
    }


    /**
     * Transformations
     */
    public void transform() {
        xmlHelper.transform();
    }
}
