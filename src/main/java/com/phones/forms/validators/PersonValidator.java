/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.forms.validators;

import com.phones.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author trunov_as
 */
@Component
public class PersonValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Person.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
    }
    
}
