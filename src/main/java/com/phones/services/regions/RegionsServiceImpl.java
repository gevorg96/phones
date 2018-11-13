/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.regions;

import com.phones.DAO.RegionsDAO;
import com.phones.entity.Regions;
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
public class RegionsServiceImpl implements RegionsService{

    @Autowired
    RegionsDAO regionsDAO;
    
    @Override
    public void create(Regions reg) {
        regionsDAO.create(reg);
    }

    @Override
    public void update(Regions reg) {
        regionsDAO.update(reg);
    }

    @Override
    public void delete(Long id) {
        regionsDAO.delete(id);
    }

    @Override
    public List<Regions> getAll() {
        return regionsDAO.getAll();
    }

    @Override
    public Regions getById(Long id){
        return regionsDAO.getById(id);
    }

    @Override
    public List<Regions> getPerPage(int page, int count) {
         return regionsDAO.getPerPage(page, count);
    }

    @Override
    public Long getCount() {
        return regionsDAO.getCount();
    }
    @Override
    public List<Regions> getPerPage(int page, int count, String search) {
         return regionsDAO.getPerPage(page, count, search);
    }

    @Override
    public Long getCount(String search) {
        return regionsDAO.getCount(search);
    }
    
}
