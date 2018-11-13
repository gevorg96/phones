/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.RegionsDAO;
import com.phones.entity.Regions;
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
public class RegionsDAOImpl implements RegionsDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Regions> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from Regions").list();
    }

    @Override
    public Regions getById(Long id) {
        return (Regions)sessionFactory.getCurrentSession().get(Regions.class, id);
    }

    @Override
    public void create(Regions reg) {
        sessionFactory.getCurrentSession().save(reg);
    }

    @Override
    public void delete(Long id) {
        Regions reg = (Regions) sessionFactory.getCurrentSession().get(Regions.class, id);
        if (reg !=null){
            sessionFactory.getCurrentSession().delete(reg);
        }
    }

    @Override
    public void update(Regions reg) {
        sessionFactory.getCurrentSession().update(reg);
    }

    @Override
    public List<Regions> getPerPage(int page, int count) {
        return sessionFactory.getCurrentSession().createQuery("from Regions").setFirstResult(page).setMaxResults(count).list();
    }
    
    @Override
    public Long getCount(){
        return (Long) sessionFactory.getCurrentSession().createCriteria(Regions.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Regions> getPerPage(int page, int count, String search) {
        return sessionFactory.getCurrentSession().createQuery("from Regions p where p.name like :search").setParameter("search", search+"%").setFirstResult(page).setMaxResults(count).list();
    }

    @Override
    public Long getCount(String search) {
        Criterion name = Restrictions.ilike("name", search+"%");
      
        Disjunction orExp = Restrictions.or(name);
        
        return (Long) sessionFactory.getCurrentSession().createCriteria(Regions.class).add(orExp).setProjection(Projections.rowCount()).uniqueResult();
    }
    
}
