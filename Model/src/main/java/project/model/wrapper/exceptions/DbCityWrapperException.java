package project.model.wrapper.exceptions;

public class DbCityWrapperException extends Exception {

    public DbCityWrapperException() {
    }

    public DbCityWrapperException(String message) {
        super(message);
    }

    public DbCityWrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbCityWrapperException(Throwable cause) {
        super(cause);
    }
}
