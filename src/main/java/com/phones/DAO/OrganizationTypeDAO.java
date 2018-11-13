/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.OrganizationType;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface OrganizationTypeDAO {
    List<OrganizationType> getAll();
    OrganizationType getById(Long id);
    void create(OrganizationType type);
    void delete(Long id);
    void update(OrganizationType type);
}
