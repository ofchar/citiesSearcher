package project.model.xmler.exceptions;

public class XMLHelperException extends XMLerException {

    public XMLHelperException() {
    }

    public XMLHelperException(String message) {
        super(message);
    }

    public XMLHelperException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLHelperException(Throwable cause) {
        super(cause);
    }
}
