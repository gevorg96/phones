/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.contacttype;

import com.phones.entity.ContactType;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface ContactTypeService {
    void create(ContactType type);
    void update(ContactType type);
    void delete(Long id);
    List<ContactType> getAll();
    ContactType getById(Long id);   
}
