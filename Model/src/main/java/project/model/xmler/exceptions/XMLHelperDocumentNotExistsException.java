package project.model.xmler.exceptions;

public class XMLHelperDocumentNotExistsException extends XMLHelperException {

    public XMLHelperDocumentNotExistsException() {
    }

    public XMLHelperDocumentNotExistsException(String message) {
        super(message);
    }

    public XMLHelperDocumentNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLHelperDocumentNotExistsException(Throwable cause) {
        super(cause);
    }
}
