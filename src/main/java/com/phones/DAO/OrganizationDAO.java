/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.Organization;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface OrganizationDAO {
    List<Organization> getAll();
    Organization getById(Long id);
    void create(Organization organization);
    void delete(Long id);
    void update(Organization organization);
    List<Organization> getPerPage(int page, int count);
    List<Organization> getPerPage(int page, int count, String search);
    Long getCount();
    Long getCount(String search);
    
}
