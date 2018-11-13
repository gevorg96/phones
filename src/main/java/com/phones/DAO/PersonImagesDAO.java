/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.PersonImages;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface PersonImagesDAO {
    List<PersonImages> getAll();
    PersonImages getById(Long id);
    void create(PersonImages images);
    void delete(Long id);
    void update(PersonImages images);
    PersonImages getByPerson(Long id);
    byte[] getImageByPerson(Long id);
}
