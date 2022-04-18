package project.model.xmler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import project.model.xmler.exceptions.XMLFileHelperException;
import project.model.xmler.templater.IDocumentTemplater;

public class XMLHelper {
    private String fileName;
    private Document document;

    public XMLHelper(String fileName) throws XMLFileHelperException {
        this.fileName = fileName;
        
        readDocument();
    }
    
    public XMLHelper(String fileName, IDocumentTemplater pattern) throws XMLFileHelperException {
        this.fileName = fileName;
        
        createDocument(pattern);
    }
    
    private void readDocument() throws XMLFileHelperException {
        this.document = XMLFileHelper.readXmlDocument(this.fileName);
    }
    
    private void createDocument(IDocumentTemplater pattern) throws XMLFileHelperException {
        this.document = pattern.getTemplate();
        
        XMLFileHelper.writeDocumentToFile(this.document, this.fileName);
    }
    
    
    private Element getRoot() {
        return this.document.getRootElement();
    }
    
    private Element getElement(Element root, String path) {
        Element currentElement = root;
        
        for(String par : path.split("\\.")) {
            currentElement = currentElement.getChild(par);
        }
        
        return currentElement;
    }
    
    public void addToDocument(String parent) {
        Element parentElement = getElement(getRoot(), parent);
        
        System.out.println(parentElement);
    }
}
