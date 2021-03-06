/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.forms.validators;

import com.phones.entity.ContactType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author trunov_as
 */

@Component
public class ContactTypeValidator implements Validator{

    
    @Override
    public boolean supports(Class<?> type) {
        return ContactType.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ContactType type = (ContactType) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Поле должно быть заполнено");
        
        if (type.getName() == null){
            errors.rejectValue("name", "NotEmpty.name.empty");
        }
        
    }
    
}
