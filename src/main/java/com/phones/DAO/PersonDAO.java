/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.Person;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface PersonDAO {
    List<Person> getAll();
    List<Person> getPersons(int page, int count);
    List<Person> getPersons(int page, int count, String searchStr);
    List<Person> getPersonsByPhone(int page, int count, String searchStr);
    Long getCount();
    Long getCount(String searchStr);
    Long getCountByPhones(String searchStr);
    Person getById(Long id);
    void create(Person person);
    void delete(Long id);
    void update(Person person);
}
