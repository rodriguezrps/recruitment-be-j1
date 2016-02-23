package de.smava.recrt.exception;

/**
 *
 */
public class RecrtServiceException extends RuntimeException {

    private Error error;

    public RecrtServiceException(String message) {
        super(message);
    }

    public RecrtServiceException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}