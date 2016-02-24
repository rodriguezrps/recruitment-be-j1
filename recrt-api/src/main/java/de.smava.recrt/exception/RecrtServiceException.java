package de.smava.recrt.exception;

/**
 *
 */
public class RecrtServiceException extends RuntimeException {

    private RecrtError error;

    public RecrtServiceException(RecrtError error) {
        this.error = error;
    }

    public RecrtError getError() {
        return error;
    }
}