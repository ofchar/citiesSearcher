package project.model.xmler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
    
    private List<Element> getElementsByName(Element root, String name) {
        return root.getChildren(name);
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
    
    /**
     * Delete parent of element, it is way to overcomplicated to explain how it works.
     * I will redesign it later.
     * 
     * @param path
     * @param parentName
     * @param queryName
     * @param queryValue
     * @throws XMLerException 
     */
    public void deleteParentOfElement(String path, String parentName, String queryName, String queryValue) throws XMLerException {
        checkDocument();
        
        Element root = getElement(getRoot(), path);
        
        List<Element> elements = getElementsByName(root, parentName);
        
        elements.removeIf(el -> el.getChild(queryName).getText().equals(queryValue));
    }
    
    public List findElements(String path, String parentName, String queryName, String queryValue) throws XMLHelperDocumentNotExistsException {
        checkDocument();
        
        Element root = getElement(getRoot(), path);
        
        List<Element> elements = getElementsByName(root, parentName);

        List<Element> found = elements.stream()
            .filter(el -> el.getChild(queryName).getText().equals(queryValue))
            .collect(Collectors.toList());
        
        return found;
    }
    
    public boolean checkElementExistence(String path, String parentName, String queryName, String queryValue) throws XMLHelperDocumentNotExistsException {
        List<Element> found = findElements(path, parentName, queryName, queryValue);
        
        return !found.isEmpty();
    }
    
    public List getAll(String path) throws XMLHelperDocumentNotExistsException, Exception {
        checkDocument();
        
        Element root = getElement(getRoot(), path);
        
        return root.getChildren();
    }
    
    public List get(String path) throws XMLHelperDocumentNotExistsException {
        checkDocument();
        
        Element root = getElement(getRoot(), path);
                
        return root.getChildren();
    }
}
