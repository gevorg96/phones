/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.contact;

import com.phones.entity.Contact;
import com.phones.entity.ContactType;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author trunov_as
 */
public interface ContactService {
    List<Contact> getContacts(int page, int count, String searchStr);
    List<Contact> getContacts(int page, int count);
    void create(Contact contact);
    void update(Contact contact);
    void delete(Long id);
    List<Contact> getAll();
    Contact getById(Long id);
    Long getCount();
    Long getCount(String searchStr);
    List<Contact> getFreeContacts(ContactType type);
}
