/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;


import com.phones.services.contactlog.ContactLogService;
import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author trunov_as
 */
@Controller
@RequestMapping("contact/log")
public class ContactLogController {
    
    @Autowired
    private ContactLogService service;
    
    
    @RequestMapping(value = "/{contact}", method = RequestMethod.GET)
    public String getLogsByContact(@PathVariable(value = "contact") String contact, ModelMap model){
         
        try {
            model.addAttribute("logs", service.getByContactName(contact));
        } catch (Exception e) {
            model.addAttribute("error", "Контакт не найден");
        }
        return "admin/logs/contact";
    }
}
