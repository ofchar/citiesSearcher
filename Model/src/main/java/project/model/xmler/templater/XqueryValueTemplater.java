package project.model.xmler.templater;

import org.jdom2.Document;
import org.jdom2.Element;

public class XqueryValueTemplater implements IDocumentTemplater {
    @Override
    public Document getTemplate() {
        Element root = new Element("value");

        Document document = new Document(root);

        return document;
    }
}
