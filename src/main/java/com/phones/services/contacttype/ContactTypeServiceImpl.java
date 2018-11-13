/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.contacttype;

import com.phones.DAO.ContactTypeDAO;
import com.phones.entity.ContactType;
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
public class ContactTypeServiceImpl implements ContactTypeService{

    @Autowired
    ContactTypeDAO contactTypeDAO;
    
    @Override
    public void create(ContactType type) {
        contactTypeDAO.create(type);
    }

    @Override
    public void update(ContactType type) {
        contactTypeDAO.update(type);
    }

    @Override
    public void delete(Long id) {
        contactTypeDAO.delete(id);
    }

    @Override
    public List<ContactType> getAll() {
        return contactTypeDAO.getAll();
    }

    @Override
    public ContactType getById(Long id){
        return contactTypeDAO.getById(id);
    }
    
}
