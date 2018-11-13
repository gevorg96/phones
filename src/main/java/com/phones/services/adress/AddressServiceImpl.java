/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.adress;

import com.phones.DAO.AddressDAO;
import com.phones.entity.Address;
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
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressDAO addressDAO;
    
    @Override
    public void create(Address address) {
        addressDAO.create(address);
    }

    @Override
    public void update(Address address) {
        addressDAO.update(address);
    }

    @Override
    public void delete(Long id) {
        addressDAO.delete(id);
    }

    @Override
    public List<Address> getAll() {
        return addressDAO.getAll();
    }

    @Override
    public Address getById(Long id){
        return addressDAO.getById(id);
    }
    
}
