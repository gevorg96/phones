/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.feedback;

import com.phones.entity.Feedback;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface FeedbackService {
    void create(Feedback feedback);
    void update(Feedback feedback);
    void delete(Long id);
    List<Feedback> getAll();
    Feedback getById(Long id);   
}
