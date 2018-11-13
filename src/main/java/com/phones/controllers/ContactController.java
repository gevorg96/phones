/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.entity.Contact;
import com.phones.entity.ContactLog;
import com.phones.entity.Person;
import com.phones.services.contact.ContactService;
import com.phones.services.contactlog.ContactLogService;
import com.phones.services.person.PersonService;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("contact")
public class ContactController {
    
    private static final Logger LOGGER = LogManager.getLogger(ContactController.class);
    
    private ContactService service;
    private PersonService pService;
    private ContactLogService logService;
    
    @Autowired 
    public void setService(ContactService service) {
        this.service = service;
    }
    @Autowired 
    public void setpService(PersonService pService) {
        this.pService = pService;
    }

    @Autowired
    public void setLogService(ContactLogService logService) {
        this.logService = logService;
    }
    
    
    
    @RequestMapping(value = "/ajax/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody String updateContact(@RequestBody Contact contact, @PathVariable(value = "id") Long id){
        contact.setPerson(pService.getById(id));
        ContactLog log = LogHelper.createLogMessageUpdate(contact);
        logService.add(log);
        service.update(contact);
        
        return "success";
    }
    
    @RequestMapping(value = "/ajax/add/{id}", method = RequestMethod.POST)
    public @ResponseBody String addContact(@RequestBody Contact contact, @PathVariable Long id){
        contact.setPerson(pService.getById(id));
        service.create(contact);
        ContactLog log = LogHelper.createLogMessageUpdate(contact);
        logService.add(log);
        return "success";
    }
    
    @RequestMapping(value = "/ajax/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String removePersonfromContact(@PathVariable Long id){
        
        Contact contact = service.getById(id);
        ContactLog log = LogHelper.createLogMessageDelete(contact);
        logService.add(log);
        Person p = contact.getPerson();
        contact.setPerson(null);
        service.update(contact);
       
        return "success";
    }
    
    private static class LogHelper{
        private static ContactLog createLogMessageUpdate(Contact contact){
            ContactLog cl = new ContactLog();
            cl.setContact(contact.getContact());
            cl.setDate(new Date());
            StringBuilder sb = new StringBuilder(contact.getPerson().getSurname()+" ");
            sb.append(contact.getPerson().getName()+" ");
            sb.append(contact.getPerson().getMiddlename());
            cl.setLog("Контакт был привязан пользователю: "+ sb.toString());
            
            return cl;
        }
        
        private static ContactLog createLogMessageDelete(Contact contact){
           ContactLog cl = new ContactLog();
            cl.setContact(contact.getContact());
            cl.setDate(new Date());
            StringBuilder sb = new StringBuilder(contact.getPerson().getSurname()+" ");
            sb.append(contact.getPerson().getName()+" ");
            sb.append(contact.getPerson().getMiddlename());
            cl.setLog("Контакт был отвязан от пользователя: "+ sb.toString());
            
            return cl;
        }
        
        
    }
}
