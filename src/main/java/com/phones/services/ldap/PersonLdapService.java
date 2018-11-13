/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.ldap;

import com.phones.ldap.domain.Person;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface PersonLdapService {
    List<Person> getAll();
    void update(Person person);
    Person findBy(String ou, String cn);
}
