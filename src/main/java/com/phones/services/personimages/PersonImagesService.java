/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.personimages;

import com.phones.entity.PersonImages;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface PersonImagesService {
    void create(PersonImages images);
    void update(PersonImages images);
    void delete(Long id);
    List<PersonImages> getAll();
    PersonImages getById(Long id);
    PersonImages getByPerson(Long id);
    byte[] getImageByPerson(Long id);
}
