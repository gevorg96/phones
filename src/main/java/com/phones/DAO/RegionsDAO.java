/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;

import com.phones.entity.Regions;
import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface RegionsDAO {
    List<Regions> getAll();
    List<Regions>getPerPage(int page, int count);
    List<Regions>getPerPage(int page, int count, String search);
    Regions getById(Long id);
    void create(Regions reg);
    void delete(Long id);
    void update(Regions reg);
    Long getCount();
    Long getCount(String search);
}
