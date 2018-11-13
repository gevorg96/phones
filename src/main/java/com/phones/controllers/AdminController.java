/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;




import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author trunov_as
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    
    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String mainPage(ModelMap model){
        return "admin/index";
    }
    
    
    
}
