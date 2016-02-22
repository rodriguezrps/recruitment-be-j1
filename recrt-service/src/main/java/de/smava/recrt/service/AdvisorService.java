package de.smava.recrt.service;

import de.smava.recrt.service.resource.AdvisorResource;

import java.util.List;

/**
 *
 */
public interface AdvisorService {

    List<AdvisorResource> getAllAdvisors() throws RecrtServiceException;

}
