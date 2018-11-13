/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.PersonDAO;
import com.phones.entity.Person;
import java.util.List;
import org.hibernate.Query;
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
public class PersonDAOImpl implements PersonDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Person> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public Person getById(Long id) {
        return (Person)sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void create(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public void delete(Long id) {
        Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, id);
        if (person !=null){
            sessionFactory.getCurrentSession().delete(person);
        }
    }

    @Override
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public List<Person> getPersons(int page, int count) {
        if (page >= 1) page = page -1;
        return sessionFactory.getCurrentSession().createQuery("SELECT p from Person p ORDER BY p.surname ASC"). setFirstResult(page).setMaxResults(count).list();
    }

    @Override
    public List<Person> getPersons(int page, int count, String searchStr) {
        if (page >= 1) page = page -1;
        String hql = "select p FROM Person p WHERE  LOWER(p.surname) like LOWER(:name)ORDER by surname ASC";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(page).setMaxResults(count);
        query.setString("name", searchStr+"%");
        
        return query.list();
    }

    @Override
    public List<Person> getPersonsByPhone(int page, int count, String searchStr) {
        if (page >= 1) page = page -1;
        String hql = "select p FROM Person p inner join p.contacts c WHERE c.contact like :name ORDER by surname ASC";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(page).setMaxResults(count);
        query.setString("name", searchStr+"%");
        
        return query.list();
    }
    
    

    @Override
    public Long getCount(String searchStr) {
        
        Criterion surname = Restrictions.ilike("surname", searchStr+"%");
        
        Disjunction orExp = Restrictions.or(surname);
        
        return (Long) sessionFactory.getCurrentSession().createCriteria(Person.class).add(orExp).setProjection(Projections.rowCount()).uniqueResult();
        
    }
    
    @Override
    public Long getCountByPhones(String searchStr) {
        
       String hql = "select count(p) FROM Person p inner join p.contacts c WHERE c.contact like :name ORDER by surname ASC";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", searchStr+"%");
        
        return (Long) query.uniqueResult();
        
    }
    
    @Override
    public Long getCount() {
        return  (Long) sessionFactory.getCurrentSession().createCriteria(Person.class).setProjection(Projections.rowCount()).uniqueResult();
    }
    
    
    
}
