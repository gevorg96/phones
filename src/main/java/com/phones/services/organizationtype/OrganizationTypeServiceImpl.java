/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.organizationtype;

import com.phones.DAO.OrganizationTypeDAO;
import com.phones.entity.OrganizationType;
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
public class OrganizationTypeServiceImpl implements OrganizationTypeService{

    @Autowired
    OrganizationTypeDAO organizationTypeDAO;
    
    @Override
    public void create(OrganizationType type) {
        organizationTypeDAO.create(type);
    }

    @Override
    public void update(OrganizationType type) {
        organizationTypeDAO.update(type);
    }

    @Override
    public void delete(Long id) {
        organizationTypeDAO.delete(id);
    }

    @Override
    public List<OrganizationType> getAll() {
        return organizationTypeDAO.getAll();
    }

    @Override
    public OrganizationType getById(Long id){
        return organizationTypeDAO.getById(id);
    }
    
}
