/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.OrganizationDAO;
import com.phones.entity.Organization;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class OrganizationDAOImpl implements OrganizationDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Organization> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Organization").list();
    }

    @Override
    public Organization getById(Long id) {
        return (Organization)sessionFactory.getCurrentSession().get(Organization.class, id);
    }

    @Override
    public void create(Organization organization) {
        sessionFactory.getCurrentSession().save(organization);
    }

    @Override
    public void delete(Long id) {
        Organization organization = (Organization) sessionFactory.getCurrentSession().get(Organization.class, id);
        if (organization !=null){
            sessionFactory.getCurrentSession().delete(organization);
        }
    }

    @Override
    public void update(Organization organization) {
        sessionFactory.getCurrentSession().update(organization);
    }
    
    
    @Override
    public List<Organization> getPerPage(int page, int count) {
        return sessionFactory.getCurrentSession().createQuery("from Organization").setFirstResult(page).setMaxResults(count).list();
    }
    
    @Override
    public List<Organization> getPerPage(int page, int count, String search) {
        return sessionFactory.getCurrentSession().createQuery("from Organization p where p.name like :search").setParameter("search", search+"%").setFirstResult(page).setMaxResults(count).list();
    }
    
    
    @Override
    public Long getCount(){
        return (Long) sessionFactory.getCurrentSession().createCriteria(Organization.class).setProjection(Projections.rowCount()).uniqueResult();
    }
    
    @Override
    public Long getCount(String search) {
        Criterion name = Restrictions.ilike("name", search+"%");
      
        Disjunction orExp = Restrictions.or(name);
        
        return (Long) sessionFactory.getCurrentSession().createCriteria(Organization.class).add(orExp).setProjection(Projections.rowCount()).uniqueResult();
    }
    
}
