/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.OrganizationTypeDAO;
import com.phones.entity.OrganizationType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class OrganizationTypeDAOImpl implements OrganizationTypeDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<OrganizationType> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from OrganizationType").list();
    }

    @Override
    public OrganizationType getById(Long id) {
        return (OrganizationType)sessionFactory.getCurrentSession().get(OrganizationType.class, id);
    }

    @Override
    public void create(OrganizationType type) {
        sessionFactory.getCurrentSession().save(type);
    }

    @Override
    public void delete(Long id) {
        OrganizationType type = (OrganizationType) sessionFactory.getCurrentSession().get(OrganizationType.class, id);
        if (type !=null){
            sessionFactory.getCurrentSession().delete(type);
        }
    }

    @Override
    public void update(OrganizationType type) {
        sessionFactory.getCurrentSession().update(type);
    }
    
}
