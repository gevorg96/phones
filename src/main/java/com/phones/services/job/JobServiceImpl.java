/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.job;

import com.phones.DAO.JobDAO;
import com.phones.entity.Job;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trunov_as
 */
@Service
@Transactional
public class JobServiceImpl implements JobService{

    @Autowired
    JobDAO jobDAO;
    
    @Override
    public void create(Job job) {
        jobDAO.create(job);
    }

    @Override
    public void update(Job job) {
        jobDAO.update(job);
    }

    @Override
    public void delete(Long id) {
        jobDAO.delete(id);
    }

    @Override
    public List<Job> getAll() {
        return jobDAO.getAll();
    }

    @Override
    public Job getById(Long id){
        return jobDAO.getById(id);
    }
    
}
