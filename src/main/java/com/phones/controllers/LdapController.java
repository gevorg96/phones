/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.ldap.domain.ContactEntry;
import com.phones.ldap.domain.Person;
import com.phones.ldap.domain.dao.ContactRepoImpl;
import com.phones.services.ldap.PersonLdapService;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ldap.NameAlreadyBoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author trunov_as
 */

@Controller
@RequestMapping("ldap")
public class LdapController {
    private static final Logger logger = LogManager.getLogger(PersonController.class);
    
    @Autowired
    private PersonLdapService service;
    
    @Autowired
    private ContactRepoImpl contactService;
    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String personLdapList(ModelMap model){
        model.addAttribute("persons",service.getAll());
        return "admin/ldap";
    }
    
    @RequestMapping(value = {"/addoredit"}, method = RequestMethod.POST)
    public String createOrUpdateRegion(@ModelAttribute("ldapForm") Person person, BindingResult result, 
            ModelMap model, final RedirectAttributes redirectAttributes){
       
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Телефон был обнавлен");
            service.update(person);
            return "redirect:/ldap";
       
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET,params = {"cn","ou"})
    public String updateLdap(@RequestParam("cn") String cn, @RequestParam("ou") String ou,ModelMap model){
        Person person = service.findBy(ou, cn);
        model.addAttribute("ldapForm", person);
        return "admin/ldap/add";
    }
    
    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public String viewLdapContacts(ModelMap model){
        List<ContactEntry> list = null;
        String error = "";
        try {
            list = contactService.find();
        } catch (EmptyResultDataAccessException e) {
            error = "Список контактов пуст";
        }
        
        model.addAttribute("error", error);
        model.addAttribute("contacts", list);
        
        return "admin/ldap/contact/index";
    }
    
    @RequestMapping(value = {"/contact/add"}, method = RequestMethod.GET)
    public String goToAddPage(){
        return "admin/ldap/contact/add";
    }
    
    @RequestMapping(value = {"/contact/update"}, method = RequestMethod.GET)
    public String goToUpdatePage(ModelMap model, @RequestParam(value = "cn") String cn){
        return "admin/ldap/contact/update";
    }
    
    @RequestMapping(value = {"/contact/delete/{cn}"}, method = RequestMethod.GET)
    public RedirectView deleteContact(RedirectAttributes attributes, @PathVariable(value = "cn") String cn){
        try {
            contactService.delete(contactService.find(cn));
            attributes.addFlashAttribute("msg", "Контакт "+cn+" удален");
        } catch (EmptyResultDataAccessException e) {
            attributes.addFlashAttribute("msg", "Error: "+e.getMessage());
        }
        return new RedirectView("/phones/ldap/contact");
    }
            
            
    
    //Ajax
    
    @RequestMapping(value = {"/ajax/contact/add"}, method = RequestMethod.POST)
    public @ResponseBody Map addContactAjax(@RequestBody ContactEntry cn){
        Map<String, String> msg = new HashMap<>();
        
        try {
            contactService.create(cn);
            msg.put("answer", "Пользователь "+cn.getDisplayName()+" успешно добавлен в Active Directory");
        } catch (NameAlreadyBoundException e) {
            msg.put("answer", "Ошибка "+e.getMessage());
        }
        return msg;
    }
    
    @RequestMapping(value = {"/ajax/contact/update"}, method = RequestMethod.POST)
    public @ResponseBody Map updateContactAjax(@RequestBody ContactEntry cn){
        Map<String, String> msg = new HashMap<>();
        
        try {
            contactService.update(cn);
            msg.put("answer", "Информация о пользователе "+cn.getDisplayName()+" успешно обнавлена в Active Directory");
        } catch (NameAlreadyBoundException e) {
            msg.put("answer", "Ошибка "+e.getMessage());
        }
        return msg;
    }
    
    @RequestMapping(value = {"/ajax/contact"}, method = RequestMethod.GET)
    public @ResponseBody Map viewLodapContractsAjax(@RequestParam(value = "start") int page, @RequestParam(value = "length") int perPage, @RequestParam(value = "search[value]", required = false, defaultValue = "") String search){
        Map<String, Object> result = new HashMap<>();
        List<ContactEntry> list = new LinkedList<>();
        String error = "";
        try {
            list = contactService.find();
            result.put("data", list);
        } catch (EmptyResultDataAccessException e) {
            error = "Список контактов пуст";
        }
        result.put("error", error);
        result.put("recordsTotal", list.size());
        result.put("recordsFiltered", list.size());
        
        
        return result;
    }
    
    @RequestMapping(value = "/ajax/contact/{cn}", method = RequestMethod.GET)
    public @ResponseBody Map viewLdapContacAjax(@PathVariable(value = "cn") String cn){
        Map<String, Object> result = new HashMap<>();
        String error = "";
        ContactEntry  ce = new ContactEntry();
        try {
            ce = contactService.find(cn);
        } catch (EmptyResultDataAccessException e) {
            error = "Контакт не найден";
        }
        
        result.put("error", error);
        result.put("contact", ce);
        
        return result;
    }
    
}
