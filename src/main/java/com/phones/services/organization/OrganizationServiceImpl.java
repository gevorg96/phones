/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.organization;

import com.phones.DAO.OrganizationDAO;
import com.phones.entity.Organization;
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
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    OrganizationDAO organizationDAO;
    
    @Override
    public void create(Organization organization) {
        organizationDAO.create(organization);
    }

    @Override
    public void update(Organization organization) {
        organizationDAO.update(organization);
    }

    @Override
    public void delete(Long id) {
        organizationDAO.delete(id);
    }

    @Override
    public List<Organization> getAll() {
        return organizationDAO.getAll();
    }

    @Override
    public Organization getById(Long id){
        return organizationDAO.getById(id);
    }
    
    @Override
    public List<Organization> getPerPage(int page, int count) {
         return organizationDAO.getPerPage(page, count);
    }

    @Override
    public Long getCount() {
        return organizationDAO.getCount();
    }
    @Override
    public List<Organization> getPerPage(int page, int count, String search) {
         return organizationDAO.getPerPage(page, count, search);
    }

    @Override
    public Long getCount(String search) {
        return organizationDAO.getCount(search);
    }
    
}
