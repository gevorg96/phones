/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.feedback;

import com.phones.DAO.FeedbackDAO;
import com.phones.entity.Feedback;
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
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    FeedbackDAO feedbackDAO;
    
    @Override
    public void create(Feedback feedback) {
        feedbackDAO.create(feedback);
    }

    @Override
    public void update(Feedback feedback) {
        feedbackDAO.update(feedback);
    }

    @Override
    public void delete(Long id) {
        feedbackDAO.delete(id);
    }

    @Override
    public List<Feedback> getAll() {
        return feedbackDAO.getAll();
    }

    @Override
    public Feedback getById(Long id){
        return feedbackDAO.getById(id);
    }
    
}
