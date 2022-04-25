package project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Element;
import project.model.wrapper.CityDataHelper;
import project.model.xmler.XMLHelper;
import project.model.xmler.exceptions.XMLFileHelperException;
import project.model.xmler.exceptions.XMLHelperDocumentNotExistsException;
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
            //however, we will just try to create new one. For now. Or for ever.
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
    
    
    
    public List index() throws Exception {
        try {
            List<Element> elements = xmlHelper.getAll("cities");
            List cities = new ArrayList<City>();
            
            for(Element element : elements) {
                cities.add(new City(element));
            }
            
            return cities;
        } catch (XMLHelperDocumentNotExistsException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("asdf");
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
}
