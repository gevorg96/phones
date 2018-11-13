/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.personimages;

import com.phones.DAO.PersonImagesDAO;
import com.phones.entity.PersonImages;
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
public class PersonImagesServiceImpl implements PersonImagesService{

    @Autowired
    PersonImagesDAO personImagesDAO;
    
    @Override
    public void create(PersonImages images) {
        personImagesDAO.create(images);
    }

    @Override
    public void update(PersonImages images) {
        personImagesDAO.update(images);
    }

    @Override
    public void delete(Long id) {
        personImagesDAO.delete(id);
    }

    @Override
    public List<PersonImages> getAll() {
        return personImagesDAO.getAll();
    }

    @Override
    public PersonImages getById(Long id){
        return personImagesDAO.getById(id);
    }

    @Override
    public PersonImages getByPerson(Long id) {
        return personImagesDAO.getByPerson(id);
    }

    @Override
    public byte[] getImageByPerson(Long id) {
        return personImagesDAO.getImageByPerson(id);
    }
    
}
