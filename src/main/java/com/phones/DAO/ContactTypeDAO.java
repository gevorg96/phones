/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.ContactType;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface ContactTypeDAO {
    List<ContactType> getAll();
    ContactType getById(Long id);
    void create(ContactType type);
    void delete(Long id);
    void update(ContactType type);
}
