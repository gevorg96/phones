/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.Address;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface AddressDAO {
    List<Address> getAll();
    Address getById(Long id);
    void create(Address address);
    void delete(Long id);
    void update(Address address);
}
