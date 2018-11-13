/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.services.regions;

import com.phones.entity.Regions;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface RegionsService {
    void create(Regions reg);
    void update(Regions reg);
    void delete(Long id);
    List<Regions> getAll();
    Regions getById(Long id);  
    List<Regions>getPerPage(int page, int count);
    Long getCount();
    List<Regions>getPerPage(int page, int count, String search);
    Long getCount(String count);
}
