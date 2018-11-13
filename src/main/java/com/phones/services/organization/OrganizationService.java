/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.organization;

import com.phones.entity.Organization;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface OrganizationService {
    void create(Organization organization);
    void update(Organization organization);
    void delete(Long id);
    List<Organization> getAll();
    Organization getById(Long id);
    List<Organization>getPerPage(int page, int count);
    Long getCount();
    List<Organization>getPerPage(int page, int count, String search);
    Long getCount(String count);
}
