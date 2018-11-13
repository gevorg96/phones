/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.ldap;

import com.phones.ldap.domain.Person;
import com.phones.ldap.domain.dao.PersonLdapDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trunov_as
 */
@Service
public class PersonLdapServiceImpl implements PersonLdapService{

    @Autowired
    private PersonLdapDAO personLdapDAO;
    
   
    
    @Override
    public List<Person> getAll() {
        return personLdapDAO.getAll();
    }

    @Override
    public void update(Person person) {
       personLdapDAO.update(person);
    }

    @Override
    public Person findBy(String ou, String cn) {
        return personLdapDAO.findBy(ou, cn);
    }
    
}
