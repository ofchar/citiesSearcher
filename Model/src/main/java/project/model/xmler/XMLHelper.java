package project.model.xmler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import project.model.xmler.exceptions.XMLFileHelperException;
import project.model.xmler.exceptions.XMLHelperDocumentNotExistsException;
import project.model.xmler.exceptions.XMLerException;
import project.model.xmler.templater.IDocumentTemplater;

public class XMLHelper {
    private String fileName;
    private Document document;

    public XMLHelper(String fileName) {
        this.fileName = fileName;
    }
    
    public void readDocument() throws XMLFileHelperException {
        this.document = XMLFileHelper.readXmlDocument(this.fileName);
    }
    
    public void createDocument(IDocumentTemplater template) throws XMLFileHelperException {
        this.document = template.getTemplate();
        
        XMLFileHelper.writeDocumentToFile(this.document, this.fileName);
    }
    
    
    /**
     * Get root of document field
     * 
     * @return Element
     */
    private Element getRoot() {
        return this.document.getRootElement();
    }
    
    /**
     * Find element inside root Element by path, where path are nodes separated by dot (.)
     * 
     * @param root
     * @param path
     * @return Element
     */
    private Element getElement(Element root, String path) {
        Element currentElement = root;
        
        for(String par : path.split("\\.")) {
            currentElement = currentElement.getChild(par);
        }
        
        return currentElement;
    }
    
    /**
     * Check document field, throw exception if field is new (document was neither read
     * nor created)
     * 
     * @throws XMLHelperDocumentNotExistsException 
     */
    private void checkDocument() throws XMLHelperDocumentNotExistsException {
        if(this.document == null) {
            throw new XMLHelperDocumentNotExistsException();
        }
    }
    
    /**
     * Adds element to the parent element of XML document stored in field.
     * 
     * @param parent
     * @param element 
     * @throws XMLHelperDocumentNotExistsException 
     */
    public void addToDocument(String parent, Element element) throws XMLHelperDocumentNotExistsException {
        checkDocument();
        
        Element parentElement = getElement(getRoot(), parent);
        
        parentElement.addContent(element);
    }
    
    public void save() throws XMLerException {
        save(this.fileName);
    }
    
    public void save(String fileName) throws XMLerException {
        checkDocument();
        
        XMLFileHelper.writeDocumentToFile(this.document, fileName);
    }
}
