/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.ContactTypeDAO;
import com.phones.entity.ContactType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class ContactTypeDAOImpl implements ContactTypeDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<ContactType> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from ContactType").list();
    }

    @Override
    public ContactType getById(Long id) {
        return (ContactType)sessionFactory.getCurrentSession().get(ContactType.class, id);
    }

    @Override
    public void create(ContactType type) {
        sessionFactory.getCurrentSession().save(type);
    }

    @Override
    public void delete(Long id) {
        ContactType type = (ContactType) sessionFactory.getCurrentSession().get(ContactType.class, id);
        if (type !=null){
            sessionFactory.getCurrentSession().delete(type);
        }
    }

    @Override
    public void update(ContactType type) {
        sessionFactory.getCurrentSession().update(type);
    }
    
}
