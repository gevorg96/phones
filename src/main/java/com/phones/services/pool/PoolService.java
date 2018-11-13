/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.pool;


import com.phones.entity.Contact;
import com.phones.entity.Pool;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface PoolService {
    void create(Pool pool);
    void update(Pool pool);
    void delete(Long id);
    List<Pool> getAll();
    Pool getById(Long id);  
    List<Contact>getContactList(Long id);
    List<Contact> getFreeContactByPool(Long id);
    
}
