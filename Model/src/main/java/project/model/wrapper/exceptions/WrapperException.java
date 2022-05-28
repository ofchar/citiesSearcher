package project.model.wrapper.exceptions;

public class WrapperException extends Exception{
    public WrapperException() {
    }

    public WrapperException(String message) {
        super(message);
    }

    public WrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrapperException(Throwable cause) {
        super(cause);
    }
}
