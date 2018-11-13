/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.person;

import com.phones.entity.Person;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface PersonService {
    List<Person> getPersons(int page, int count, String searchStr);
    List<Person> getPersons(int page, int count);
    void create(Person person);
    void update(Person person);
    void delete(Long id);
    List<Person> getAll();
    Person getById(Long id); 
    Long getCount();
    Long getCount(String searchStr);
}
