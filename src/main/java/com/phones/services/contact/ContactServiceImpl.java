/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.contact;

import com.phones.DAO.ContactDAO;
import com.phones.DAO.ContactLogDAO;
import com.phones.entity.Contact;
import com.phones.entity.ContactLog;
import com.phones.entity.ContactType;
import java.util.Date;
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
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactDAO contactDAO;
    
    @Override
    public void create(Contact contact) {
        contactDAO.create(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDAO.update(contact);
    }

    @Override
    public void delete(Long id) {
        contactDAO.delete(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactDAO.getAll();
    }

    @Override
    public Contact getById(Long id){
        return contactDAO.getById(id);
    }

    @Override
    public List<Contact> getContacts(int page, int count) {
       return contactDAO.getContacts(page, count);
    }

    @Override
    public List<Contact> getContacts(int page, int count, String searchStr) {
        return contactDAO.getContacts(page, count, searchStr);
    }
    
     @Override
    public Long getCount() {
        return contactDAO.getCount();
    }
    
    @Override
    public Long getCount(String searchStr) {
        return contactDAO.getCount(searchStr);
    }

    @Override
    public List<Contact> getFreeContacts(ContactType type) {
        return contactDAO.getFreeContacts(type);
    }

    

    
    
}
