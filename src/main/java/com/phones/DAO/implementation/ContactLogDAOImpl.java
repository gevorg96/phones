/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;


import com.phones.DAO.ContactLogDAO;
import com.phones.entity.ContactLog;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class ContactLogDAOImpl implements ContactLogDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ContactLog> getByContactName(String contactName) {
        String hql = "FROM ContactLog c WHERE  c.contact = ?";
        return sessionFactory.getCurrentSession().createQuery(hql).setString(0, contactName).list();
    }

    @Override
    public void add(ContactLog log) {
        sessionFactory.getCurrentSession().save(log);
    }
    
    
    
}
