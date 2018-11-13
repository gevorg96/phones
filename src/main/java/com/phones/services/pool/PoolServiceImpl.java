/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.pool;

import com.phones.DAO.PoolDAO;
import com.phones.entity.Contact;
import com.phones.entity.Pool;
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
public class PoolServiceImpl implements PoolService{

    @Autowired
    PoolDAO poolDAO;

    @Override
    public void create(Pool pool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pool pool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pool> getAll() {
        return poolDAO.getAll();
    }

    @Override
    public Pool getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getContactList(Long id) {
        return poolDAO.getContactList(id);
    }

    @Override
    public List<Contact> getFreeContactByPool(Long id) {
        return poolDAO.getFreeContactByPool(id);
    }

}
