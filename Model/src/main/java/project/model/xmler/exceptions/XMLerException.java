package project.model.xmler.exceptions;

public class XMLerException extends Exception {

    public XMLerException() {
    }

    public XMLerException(String message) {
        super(message);
    }

    public XMLerException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLerException(Throwable cause) {
        super(cause);
    }
}
