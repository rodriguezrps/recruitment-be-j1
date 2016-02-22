package de.smava.recrt.rest.validator;

import de.smava.recrt.service.resource.AdvisorResource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 */
public class AdvisorValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AdvisorResource.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {

        //ValidationUtils.rejectIfEmpty(e, "id", "id.empty");

        //AdvisorResource p = (AdvisorResource) target;

        //perform additional checks
        //if name already exists or ?
    }
}