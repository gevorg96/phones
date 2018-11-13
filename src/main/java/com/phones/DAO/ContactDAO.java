/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.Contact;
import com.phones.entity.ContactType;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface ContactDAO {
    List<Contact> getAll();
    List<Contact> getContacts(int page, int count);
    List<Contact> getContacts(int page, int count, String searchStr);
    Contact getById(Long id);
    void create(Contact contact);
    void delete(Long id);
    void update(Contact contact);
    List<Contact> getByPerson(Long id);
    Long getCount();
    Long getCount(String searchStr);
    List<Contact> getFreeContacts(ContactType type);
}
