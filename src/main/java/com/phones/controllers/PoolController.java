/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;





import com.phones.entity.Contact;
import com.phones.entity.Pool;
import com.phones.services.pool.PoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author trunov_as
 */
@RequestMapping("pool")
@Controller
public class PoolController {
    
    @Autowired
    PoolService service;
    
    @RequestMapping(value = "")
    public String getPersonList(){
        return "admin/pool";
    }
    
   @RequestMapping(value = "ajax/list", method = RequestMethod.GET)
   public @ResponseBody List<Pool> getPoolList(){
       return service.getAll();
   }
   
   @RequestMapping(value = "ajax/{id}", method = RequestMethod.GET)
   public @ResponseBody List<Contact> getPhonesByPool(@PathVariable(value="id") Long id){
       return service.getContactList(id);
   }
   
   @RequestMapping(value = "ajax/free/{id}", method = RequestMethod.GET)
   public @ResponseBody List<Contact> getFreePhonesByPool(@PathVariable(value="id") Long id){
       return service.getFreeContactByPool(id);
   }
    
    
    
}
