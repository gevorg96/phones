/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.person;

import com.phones.DAO.ContactDAO;
import com.phones.DAO.PersonDAO;
import com.phones.entity.Contact;
import com.phones.entity.Person;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trunov_as
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonDAO personDAO;
    
    @Autowired
    ContactDAO contactDAO;
    
    @Override
    public void create(Person person) {
        personDAO.create(person);
    }

    @Override
    public void update(Person person) {
        
        Person newPerson = personDAO.getById(person.getId());
        newPerson.setNote(person.getNote());
        newPerson.setContactGroup(person.getContactGroup());
        newPerson.setStatus(person.getStatus());
        newPerson.setRoom(person.getRoom());
        
        personDAO.update(newPerson);
        
        for(Contact contact : person.getContacts()){
                    Contact newContact = contactDAO.getById(contact.getId());
                    newContact.setContact(contact.getContact());
                    newContact.setRank(contact.getRank());
                    newContact.setRoom(contact.getRoom());
                    contactDAO.update(newContact);
        }
    }

    @Override
    public void delete(Long id) {
        personDAO.delete(id);
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @Override
    public Person getById(Long id){
        return personDAO.getById(id);
    }

    @Override
    public List<Person> getPersons(int page, int count) {
            return personDAO.getPersons(page, count);
    }
    
    @Override
    public List<Person> getPersons(int page, int count, String searchStr) {
        
        if (searchStr.matches("[0-9]+")){
            return personDAO.getPersonsByPhone(page, count, searchStr);
        } else {
            return personDAO.getPersons(page, count, searchStr);
        }
    }

    @Override
    public Long getCount() {
        return personDAO.getCount();
    }
    
    @Override
    public Long getCount(String searchStr) {
        if (searchStr.matches("[0-9]+")){
            return personDAO.getCountByPhones(searchStr);
        }else{
            return personDAO.getCount(searchStr);
        }
    }
}
