/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.ContactDAO;
import com.phones.DAO.ContactLogDAO;
import com.phones.entity.Contact;
import com.phones.entity.ContactType;
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
public class ContactDAOImpl implements ContactDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Contact> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public Contact getById(Long id) {
        return (Contact)sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    @Override
    public void create(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public void delete(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        if (contact !=null){
            sessionFactory.getCurrentSession().delete(contact);
        }
    }

    @Override
    public void update(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }

    @Override
    public List<Contact> getByPerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getContacts(int page, int count) {
        if (page >= 1) page = page -1;
        return sessionFactory.getCurrentSession().createQuery("from Contact").setFirstResult(page*count).setMaxResults(count).list();
    }

    @Override
    public List<Contact> getContacts(int page, int count, String searchStr) {
        if (page >= 1) page = page -1;
        String hql = "FROM Contact c WHERE  LOWER(c.name) like LOWER(:name)";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(page*count).setMaxResults(count);
        query.setString("name", "%"+searchStr+"%");
        return query.list();
        
    }

    @Override
    public Long getCount() {
        return  (Long) sessionFactory.getCurrentSession().createCriteria(Contact.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public Long getCount(String searchStr) {
        Criterion name = Restrictions.ilike("name", "%"+searchStr+"%");
        Disjunction orExp = Restrictions.or(name);
        return (Long) sessionFactory.getCurrentSession().createCriteria(Contact.class).add(orExp).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Contact> getFreeContacts(ContactType type) {
        String hql = "FROM Contact c WHERE c.person is null and c.type = :type";
        Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("type", type);
        return query.list();
    }
    
}
