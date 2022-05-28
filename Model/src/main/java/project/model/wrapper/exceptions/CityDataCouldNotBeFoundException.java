package project.model.wrapper.exceptions;

public class CityDataCouldNotBeFoundException extends WrapperException {

    public CityDataCouldNotBeFoundException() {
    }

    public CityDataCouldNotBeFoundException(String message) {
        super(message);
    }

    public CityDataCouldNotBeFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CityDataCouldNotBeFoundException(Throwable cause) {
        super(cause);
    }
}
