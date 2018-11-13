/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.PersonImagesDAO;
import com.phones.entity.PersonImages;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class PersonImagesDAOImpl implements PersonImagesDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<PersonImages> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from PersonImages").list();
    }

    @Override
    public PersonImages getById(Long id) {
        return (PersonImages)sessionFactory.getCurrentSession().get(PersonImages.class, id);
    }

    @Override
    public void create(PersonImages images) {
        sessionFactory.getCurrentSession().save(images);
    }

    @Override
    public void delete(Long id) {
        PersonImages images = (PersonImages) sessionFactory.getCurrentSession().get(PersonImages.class, id);
        if (images !=null){
            sessionFactory.getCurrentSession().delete(images);
        }
    }

    @Override
    public void update(PersonImages images) {
        sessionFactory.getCurrentSession().update(images);
    }

    @Override
    public PersonImages getByPerson(Long id) {
         return (PersonImages) sessionFactory.getCurrentSession().createQuery("SELECT i FROM PersonImages i where i.person.id = :id").setParameter("id", id).list().get(0);
    }

    @Override
    public byte[] getImageByPerson(Long id) {
        PersonImages p = (PersonImages) sessionFactory.getCurrentSession().createQuery("SELECT i FROM PersonImages i where i.person.id = :id").setParameter("id", id).list().get(0);
        byte[] b = p.getImage();
        
        return b;
    }
    
    
}
