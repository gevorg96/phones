/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.JobDAO;
import com.phones.entity.Job;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class JobDAOImpl implements JobDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Job> getAll() {
      return sessionFactory.getCurrentSession().createQuery("from Job").list();
    }

    @Override
    public Job getById(Long id) {
        return (Job)sessionFactory.getCurrentSession().get(Job.class, id);
    }

    @Override
    public void create(Job job) {
        sessionFactory.getCurrentSession().save(job);
    }

    @Override
    public void delete(Long id) {
        Job job = (Job) sessionFactory.getCurrentSession().get(Job.class, id);
        if (job !=null){
            sessionFactory.getCurrentSession().delete(job);
        }
    }

    @Override
    public void update(Job job) {
        sessionFactory.getCurrentSession().update(job);
    }
    
}
