/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.ldap.domain.dao;

import com.phones.ldap.domain.ContactEntry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ldap.NameAlreadyBoundException;
import org.springframework.ldap.core.LdapTemplate;
import static org.springframework.ldap.query.LdapQueryBuilder.query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class ContactRepoImpl implements ContactRepo{

    private LdapTemplate ldapTemplate;

    @Autowired
    public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }
    
    @Override
    public void delete(ContactEntry contact) throws EmptyResultDataAccessException{
        ldapTemplate.delete(contact);
    }

    @Override
    public void update(ContactEntry contact) throws EmptyResultDataAccessException{
       ldapTemplate.update(contact);
    }

    @Override
    public void create(ContactEntry contact) throws NameAlreadyBoundException{
        String cn = contact.getGivenName()+" "+contact.getSn();
        contact.setCn(cn);
        ldapTemplate.create(contact);
    }

    @Override
    public List<ContactEntry> find() throws EmptyResultDataAccessException{
        return ldapTemplate.findAll(ContactEntry.class);
    }

    @Override
    public ContactEntry find(String containerName) throws EmptyResultDataAccessException{
        return ldapTemplate.findOne(query().where("cn").is(containerName), ContactEntry.class);
    }
    
    
    
    
}
