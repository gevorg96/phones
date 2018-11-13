/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;




import com.phones.entity.Person;
import com.phones.services.person.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author trunov_as
 */
@RequestMapping("/")
@Controller
public class MainController {
     @Autowired
     PersonService service;
    
    @RequestMapping(value = "")
    public String getPersonList(ModelMap model){
        return "index";
    }
    
    @RequestMapping(value="/main/rest/get-person/{page}/{perPage}/{search}")
    public @ResponseBody List<Person> getRestPersonsPerPageAndSearch(@PathVariable int page, @PathVariable int perPage, @PathVariable String search){
        return service.getPersons(page, perPage, search);
    }
    
    @RequestMapping(value="/main/rest/get-person/{page}/{perPage}")
    public @ResponseBody List<Person> getRestPersonsPerPage(@PathVariable int page, @PathVariable int perPage){
           return service.getPersons(page, perPage);
    }
    
    @RequestMapping(value="/main/rest/get-count/")
    public @ResponseBody Long restCount(){
        return service.getCount();
    }
    
    @RequestMapping(value="/main/rest/get-count/{search}")
    public @ResponseBody Long searchRestCount(@PathVariable String search){
        return service.getCount(search);
    }
}
