/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.FeedbackDAO;
import com.phones.entity.Feedback;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class FeedbackDAOImpl implements FeedbackDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Feedback> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from Feedback").list();
    }

    @Override
    public Feedback getById(Long id) {
        return (Feedback)sessionFactory.getCurrentSession().get(Feedback.class, id);
    }

    @Override
    public void create(Feedback feedback) {
        sessionFactory.getCurrentSession().save(feedback);
    }

    @Override
    public void delete(Long id) {
        Feedback feedback = (Feedback) sessionFactory.getCurrentSession().get(Feedback.class, id);
        if (feedback !=null){
            sessionFactory.getCurrentSession().delete(feedback);
        }
    }

    @Override
    public void update(Feedback feedback) {
        sessionFactory.getCurrentSession().update(feedback);
    }
    
}
