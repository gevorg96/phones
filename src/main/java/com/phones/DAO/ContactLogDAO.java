/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO;


import com.phones.entity.ContactLog;

import java.util.List;

/**
 *
 * @author trunov_as
 */
public interface ContactLogDAO {
    List<ContactLog> getByContactName(String contactName);
    void add(ContactLog log);
}
