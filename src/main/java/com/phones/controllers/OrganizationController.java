/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.services.organization.OrganizationService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author trunov_as
 */
@Controller
@RequestMapping("organization")
public class OrganizationController {
 
    @Autowired
    private OrganizationService service;
    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String organizationList(ModelMap model){
        model.addAttribute("organizations", service.getAll());
        return "admin/organization";
    }
    
    //AJAX
    
    @RequestMapping(value = "/ajax/get", method = RequestMethod.GET)
    public @ResponseBody Map getPersonsToAjax(@RequestParam(value = "start") int page, @RequestParam(value = "length") int perPage, @RequestParam(value = "search[value]", required = false, defaultValue = "") String search){
       Map<String, Object> result = new HashMap<>();
        if (!search.equals("")){
           Long count = service.getCount(search);
           result.put("recordsTotal", count);
           result.put("recordsFiltered", count);
           result.put("data", service.getPerPage(page, perPage, search));
           
       }else{
            Long count = service.getCount();
            result.put("recordsTotal", count);
            result.put("recordsFiltered", count);
            result.put("data", service.getPerPage(page, perPage));
       }
        return result;
    }
    
}
