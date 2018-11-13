/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.ldap.domain.dao;

import com.phones.ldap.domain.ContactEntry;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface ContactRepo {
    void delete(ContactEntry contact);
    void update(ContactEntry contact);
    void create(ContactEntry contact);
    List<ContactEntry> find();
    ContactEntry find(String containerName);
}
