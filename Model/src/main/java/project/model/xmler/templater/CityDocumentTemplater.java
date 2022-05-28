package project.model.xmler.templater;

import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

public class CityDocumentTemplater implements IDocumentTemplater {
    @Override
    public Document getTemplate() {
        Element root = new Element("citiesSearcher");

        //DTD declaration
        DocType docType = new DocType("citiesSearcher", "resources/validation/cities.dtd");

        //XSD declaration
        Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.addNamespaceDeclaration(xsi);
        root.setAttribute("noNamespaceSchemaLocation","resources/validation/cities.xsd", xsi);

        Element citiesElement = new Element("cities");

        root.addContent(citiesElement);

        Document document = new Document(root, docType);

        return document;
    }
}
