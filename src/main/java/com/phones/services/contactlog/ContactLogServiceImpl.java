/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.contactlog;

import com.phones.DAO.ContactLogDAO;
import com.phones.entity.ContactLog;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author trunov_as
 */
@Service
@Transactional
public class ContactLogServiceImpl implements ContactLogService{
    
    @Autowired
    private ContactLogDAO repository;
    
    @Override
    public List<ContactLog> getByContactName(String contactName){
        return repository.getByContactName(contactName);
    }

    @Override
    public void add(ContactLog log) {
        repository.add(log);
    }
}
