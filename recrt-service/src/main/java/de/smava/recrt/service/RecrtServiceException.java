package de.smava.recrt.service;

import de.smava.recrt.service.resource.ErrorResource;

/**
 *
 */
public class RecrtServiceException extends RuntimeException {

    private ErrorResource errorResource;

    public RecrtServiceException(String message) {
        super(message);
    }

    public RecrtServiceException(ErrorResource errorResource) {
        super(errorResource.getMessage());
        this.errorResource = errorResource;
    }

    public ErrorResource getErrorResource() {
        return errorResource;
    }
}