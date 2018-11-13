/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.organizationtype;

import com.phones.entity.OrganizationType;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface OrganizationTypeService {
    void create(OrganizationType type);
    void update(OrganizationType type);
    void delete(Long id);
    List<OrganizationType> getAll();
    OrganizationType getById(Long id);   
}
