package project.model.wrapper.exceptions;

public class WikipediaWrapperException extends WrapperException {

    public WikipediaWrapperException() {
    }

    public WikipediaWrapperException(String message) {
        super(message);
    }

    public WikipediaWrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public WikipediaWrapperException(Throwable cause) {
        super(cause);
    }
}
