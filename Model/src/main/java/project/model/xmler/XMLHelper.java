package project.model.xmler;

import java.util.List;
import java.util.stream.Collectors;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
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
     * Get root of document found in document field
     *
     * @return Element
     */
    private Element getRoot() {
        return this.document.getRootElement();
    }

    /**
     * Find element inside root Element by path, where path are nodes separated
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

    /**
     * Save changes to the file with name provided in the constructor.
     *
     * @throws XMLerException
     */
    public void save() throws XMLerException {
        save(this.fileName);
    }

    /**
     * Save changes to the file with fileName file
     *
     * @param fileName
     * @throws XMLerException
     */
    public void save(String fileName) throws XMLerException {
        checkDocument();

        XMLFileHelper.writeDocumentToFile(this.document, fileName);
    }

    /**
     * Delete parent of element. Path specifies where to look for elements to
     * delete, parentName specifies name of the actual element that will be
     * deleted. queryName and queryValue are used to query all potential
     * elements, where name is a name of element inside parentElement, and value
     * is.. value of that element :)
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
    public List findElements(String path, String parentName, String queryName, String queryValue) throws XMLHelperDocumentNotExistsException {
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
    public List getAll(String path) throws XMLHelperDocumentNotExistsException {
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
     * @param path
     * @param parentName
     * @param queryName
     * @param queryValue
     * @param elementName
     * @param newValue
     * @throws XMLHelperDocumentNotExistsException
     */
    public void update(String path, String parentName, String queryName, String queryValue, String elementName, String newValue) throws XMLHelperDocumentNotExistsException {
        List<Element> elements = findElements(path, parentName, queryName, queryValue);

        if (elements.isEmpty()) {
            //but hey nothing to update
        }

        elements.get(0).getChildren(elementName).get(0).setText(newValue);
    }

    public List getXpath(String xpathString) throws XMLHelperDocumentNotExistsException {
        checkDocument();

        XPathFactory xpath = XPathFactory.instance();

        XPathExpression<Element> expr = xpath.compile(xpathString, Filters.element());

        return expr.evaluate(document);
    }
}

