/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author trunov_as
 */
@Controller
@RequestMapping("sync")
public class SyncController {
    
    private static final Logger LOGGER = LogManager.getLogger(SyncController.class);
    
    @RequestMapping(value = {""}, method=RequestMethod.GET)
    public String getContactList(){
        return "admin/sync";
    }
}
