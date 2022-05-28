package project.model.xmler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import project.model.xmler.exceptions.XMLFileHelperException;
import project.model.xmler.exceptions.XMLHelperDocumentNotExistsException;
import project.model.xmler.exceptions.XMLHelperException;
import project.model.xmler.exceptions.XMLerException;
import project.model.xmler.templater.IDocumentTemplater;

public class XMLHelper {

    private String fileName;
    private Document document;

    public XMLHelper(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Read document from fileName provided in constructor, and store it in doument field.
     *
     * @throws XMLFileHelperException
     */
    public void readDocument() throws XMLFileHelperException {
        this.document = XMLFileHelper.readXmlDocument(this.fileName);
    }

    /**
     * Create document from provided template and save it into file with name provided in constructor.
     *
     * @param template
     * @throws XMLFileHelperException
     */
    public void createDocument(IDocumentTemplater template) throws XMLFileHelperException {
        this.document = template.getTemplate();

        XMLFileHelper.writeDocumentToFile(this.document, this.fileName);
    }


    /**
     * Get root of document found in document field
     *
     * @return Element
     */
    private Element getRoot() {
        return this.document.getRootElement();
    }

    /**
     * Find element inside root Element by path, where path is nodes separated
     * by dot (.)
     *
     * @param root
     * @param path
     * @return Element
     */
    private Element getElement(Element root, String path) {
        Element currentElement = root;

        for (String par : path.split("\\.")) {
            currentElement = currentElement.getChild(par);
        }

        return currentElement;
    }

    /**
     * Get all children of root Element by name
     *
     * @param root
     * @param name
     * @return List
     */
    private List<Element> getElementsByName(Element root, String name) {
        return root.getChildren(name);
    }

    /**
     * Check document field, throw exception if field is null (document was
     * neither read nor created)
     *
     * @throws XMLHelperDocumentNotExistsException
     */
    private void checkDocument() throws XMLHelperDocumentNotExistsException {
        if (this.document == null) {
            throw new XMLHelperDocumentNotExistsException();
        }
    }

    /**
     * Save changes to the file with name provided in the constructor.
     *
     * @throws XMLHelperDocumentNotExistsException
     * @throws XMLFileHelperException
     */
    public void save() throws XMLHelperDocumentNotExistsException,XMLFileHelperException {
        save(this.fileName);
    }

    /**
     * Save changes to the file with fileName file
     *
     * @param fileName
     * @throws XMLHelperDocumentNotExistsException
     * @throws XMLFileHelperException
     */
    public void save(String fileName) throws XMLHelperDocumentNotExistsException, XMLFileHelperException {
        checkDocument();

        XMLFileHelper.writeDocumentToFile(this.document, fileName);
    }


    /**
     * Adds element to the parent element of XML document stored in field.
     * This DOES NOT modify any file, it only changes document field of this class.
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

    /**
     * Delete parent of element. Path specifies where to look for elements to
     * delete, parentName specifies name of the actual element that will be
     * deleted. queryName and queryValue are used to query all potential
     * elements, where name is a name of element inside parentElement, and value
     * is.. value of that element :)
     *
     * This DOES NOT modify any file, it only changes document field of this class.
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

    /**
     * Find all matching elements. Path specifies where to look for elements,
     * parentName specifies name of the actual element that we are querying.
     * queryName and queryValue are used to query all potential elements, where
     * name is a name of element inside parentElement, and value is.. value of
     * that element :)
     *
     * @param path
     * @param parentName
     * @param queryName
     * @param queryValue
     * @return List
     * @throws XMLHelperDocumentNotExistsException
     */
    public List<Element> findElements(String path, String parentName, String queryName, String queryValue) throws XMLHelperDocumentNotExistsException {
        checkDocument();

        Element root = getElement(getRoot(), path);

        List<Element> elements = getElementsByName(root, parentName);

        List<Element> found = elements.stream()
                .filter(el -> el.getChild(queryName).getText().equals(queryValue))
                .collect(Collectors.toList());

        return found;
    }

    /**
     * Check if there are any elements matching criteria. Path specifies where
     * to look for elements, parentName specifies name of the actual element
     * that we are querying. queryName and queryValue are used to query all
     * potential elements, where name is a name of element inside parentElement,
     * and value is.. value of that element :)
     *
     * @param path
     * @param parentName
     * @param queryName
     * @param queryValue
     * @return boolean
     * @throws XMLHelperDocumentNotExistsException
     */
    public boolean checkElementExistence(String path, String parentName, String queryName, String queryValue) throws XMLHelperDocumentNotExistsException {
        List<Element> found = findElements(path, parentName, queryName, queryValue);

        return !found.isEmpty();
    }

    /**
     * Get all elements at path.
     *
     * @param path
     * @return List
     * @throws XMLHelperDocumentNotExistsException
     */
    public List<Element> getAll(String path) throws XMLHelperDocumentNotExistsException {
        checkDocument();

        Element root = getElement(getRoot(), path);

        return root.getChildren();
    }

    /**
     * Update element that matched criteria Path specifies where to look for
     * elements, parentName specifies name of the actual element that we are
     * querying. queryName and queryValue are used to query all potential
     * elements, where name is a name of element inside parentElement, and value
     * is.. value of that element :) elementName specifies which element inside
     * found Element will be updated, and newValue, well.. specifies new value.
     * Sorry.
     *
     * This DOES NOT modify any file, it only changes document field of this class.
     *
     * @param path
     * @param parentName
     * @param queryName
     * @param queryValue
     * @param elementName
     * @param newValue
     * @throws XMLHelperDocumentNotExistsException
     */
    public void update(String path, String parentName, String queryName, String queryValue, String elementName, String newValue) throws XMLHelperException {
        List<Element> elements = findElements(path, parentName, queryName, queryValue);

        if (elements.isEmpty()) {
            throw new XMLHelperException("Nothing to update");
        }

        elements.get(0).getChildren(elementName).get(0).setText(newValue);
    }

    /**
     * Get list of Elements found by xpath provided as the argument.
     *
     * @param xpathString
     * @return
     * @throws XMLHelperDocumentNotExistsException
     */
    public List<Element> getXpath(String xpathString) throws XMLHelperDocumentNotExistsException {
        checkDocument();

        XPathFactory xpath = XPathFactory.instance();

        XPathExpression<Element> expr = xpath.compile(xpathString, Filters.element());

        return expr.evaluate(document);
    }


    /**
     * Perform DTD or XSD validation of the document.
     *
     * @param type
     * @return
     * @throws Exception
     */
    private boolean validate(XMLReaders type) throws XMLFileHelperException {
        SAXBuilder builder = new SAXBuilder(type);

        try {
            builder.build(new File(this.fileName));
        } catch (JDOMException e) {
            return false;
        } catch (IOException e) {
            throw new XMLFileHelperException("Error while loading file", e);
        }

        return true;
    }

    public boolean validateXsd() throws Exception{
        return validate(XMLReaders.XSDVALIDATING);
    }

    public boolean validateDtd() throws Exception{
        return validate(XMLReaders.DTDVALIDATING);
    }


    public void transform(String xslFile, String resultFileName) throws XMLHelperException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;

        try {
            transformer = transformerFactory.newTransformer(new StreamSource(xslFile));
        } catch (TransformerConfigurationException e) {
            throw new XMLHelperException(e);
        }

        Source sourceStream = new StreamSource(this.fileName);
        Result resultStream = new StreamResult(resultFileName);

        try {
            transformer.transform(sourceStream, resultStream);
        } catch (TransformerException e) {
            throw new XMLHelperException(e);
        }
    }
}

