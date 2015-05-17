/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.validation;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sobranie
 */
public class ValidatorWrapper implements Validator {
    
    Logger logger = LoggerFactory.getLogger(ValidatorWrapper.class);
    
    private final Validator validator;
    
    public ValidatorWrapper(Validator validator) {
        this.validator = validator;
    }
    
    public <T> void tryValidate(T Object, Class<?>... groups) {
        Set<ConstraintViolation<T>> cv = null;
        try {
            cv = validator.validate(Object, groups);
        } catch (IllegalArgumentException | ValidationException ex) {
            throw ex;
        } catch (TypeNotPresentException ex) {
            //do nothing
            logger.warn("tryValidate {} got java.lang.TypeNotPresentException , ignored", Object);
        }
        if (cv != null && cv.size() > 0) {
            throw InvalidException.create(cv);
        }
    }
    
    public <T> void tryValidateProperty(T object, String propertyName, Class<?>... groups) {
        Set<ConstraintViolation<T>> cv;
        try {
            cv = validator.validateProperty(object, propertyName, groups);
        } catch (IllegalArgumentException | ValidationException ex) {
            throw ex;
        }
        if (cv != null && cv.size() > 0) {
            throw InvalidException.create(cv);
        }
    }
    
    public <T> void tryValidateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        Set<ConstraintViolation<T>> cv;
        try {
            cv = validator.validateValue(beanType, propertyName, value, groups);
        } catch (IllegalArgumentException | ValidationException ex) {
            throw ex;
        }
        if (cv != null && cv.size() > 0) {
            throw InvalidException.create(cv);
        }
    }

    /**
     * Convenient method for 'quick' validate a string value against a Regex.
     *
     * @param regex
     * @param value
     */
    public void tryValidateRegex(String regex, String value) {
        try {
            if (!Pattern.compile(regex).matcher(value).matches()) {
                throw InvalidException.create(regex, value);
            }
        } catch (PatternSyntaxException ex) {
            logger.error("Regex {} has syntax error.", regex);
        }
    }
    
    @Override
    public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        return validator.validate(object, groups);
    }
    
    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
        return validator.validateProperty(object, propertyName, groups);
    }
    
    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        return validator.validateValue(beanType, propertyName, value, groups);
    }
    
    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
        return validator.getConstraintsForClass(clazz);
    }
    
    @Override
    public <T> T unwrap(Class<T> type) {
        return validator.unwrap(type);
    }
    
    @Override
    public ExecutableValidator forExecutables() {
        return validator.forExecutables();
    }
}
