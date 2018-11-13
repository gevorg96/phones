/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.AddressDAO;
import com.phones.entity.Address;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class AddressDAOImpl implements AddressDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Address> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from Address").list();
    }

    @Override
    public Address getById(Long id) {
        return (Address)sessionFactory.getCurrentSession().get(Address.class, id);
    }

    @Override
    public void create(Address address) {
        sessionFactory.getCurrentSession().save(address);
    }

    @Override
    public void delete(Long id) {
        Address address = (Address) sessionFactory.getCurrentSession().get(Address.class, id);
        if (address !=null){
            sessionFactory.getCurrentSession().delete(address);
        }
    }

    @Override
    public void update(Address address) {
        sessionFactory.getCurrentSession().update(address);
    }
    
}
