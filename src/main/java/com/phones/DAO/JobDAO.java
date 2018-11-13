/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.Job;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface JobDAO {
    List<Job> getAll();
    Job getById(Long id);
    void create(Job job);
    void delete(Long id);
    void update(Job job);
}
