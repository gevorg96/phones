/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.entity.Contact;
import com.phones.entity.Person;
import com.phones.forms.validators.PersonValidator;
import com.phones.helpers.UniqueRoomList;
import com.phones.helpers.log.LogFormer;
import com.phones.services.contact.ContactService;
import com.phones.services.contacttype.ContactTypeService;
import com.phones.services.person.PersonService;
import com.phones.services.personimages.PersonImagesService;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author trunov_as
 */

@Controller
@RequestMapping("person")
public class PersonController {
    
    
    
    private static final Logger logger = LogManager.getLogger(PersonController.class);
    
    @Autowired
    PersonService service;
    
    @Autowired
    PersonImagesService imageService;
    
    @Autowired
    ContactService contactService;
    
    @Autowired
    ContactTypeService contactTypeService;
    
    @Autowired
    private PersonValidator personValidator; 
    
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(personValidator);
    }
    
    @RequestMapping(value = {""}, method=RequestMethod.GET)
    public String getPersonList(ModelMap model){
        List<Person> list = service.getPersons(0, 20);
        Long count = service.getCount();
        int maxPage = (int) Math.floor(count/20);
        model.addAttribute("persons", list);
        model.addAttribute("curentPage", 1);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("count", count);
        return "admin/person";
    }
    
    @RequestMapping(params = {"page"}, method = RequestMethod.GET)
    public String getPersonList(ModelMap model, @RequestParam("page") int page){
        List<Person> list = service.getPersons(page, 20);
        Long count = service.getCount();
        int maxPage = (int) Math.floor(count/20);
        model.addAttribute("persons", list);
        model.addAttribute("curentPage", page);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("count", count);
        return "admin/person";
    }
    
    @RequestMapping(params = {"page","search"}, method = RequestMethod.GET)
    public String getPersonList(ModelMap model, @RequestParam("page") int page, @RequestParam("search") String search){
        List<Person> list = service.getPersons(page, 20, search);
        Long count = service.getCount(search);
        int maxPage = (int) Math.floor(count/20);
        model.addAttribute("persons",list);
        model.addAttribute("curentPage", page);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("search", search);
        model.addAttribute("count", count);
        return "admin/person";
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET,params = {"id"})
    public String UpdatePerson(ModelMap model, @RequestParam("id") Long id){
        Person person = service.getById(id);
        
        UniqueRoomList list = new UniqueRoomList(person.getContacts());
        
        model.addAttribute("contactTypes", contactTypeService.getAll());
        model.addAttribute("personForm", person);
        model.addAttribute("uniqueRoom", list.getUniqueRoomList());
       
        return "admin/person/add";
    
    }
    
    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String editPerson(@ModelAttribute("personForm") Person person, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
           return "admin/person/add";
        } else {
            service.update(person);
            redirectAttributes.addFlashAttribute("css", "success");
            String contactMsg = "Информация пользователя обнавлена<br /> ";
            redirectAttributes.addFlashAttribute("msg", contactMsg);
                
            return "redirect:/person";
        }
    }
    
    @RequestMapping(value = {"/addContact"}, method = RequestMethod.POST)
    public String addContact(ModelMap model, @RequestParam(name = "personId") Long id, @RequestParam(name = "type") Long type,@RequestParam(name = "newContact") String name, @RequestParam(name = "newRoom") String room){
            Person person = service.getById(id);
            Contact contact = new Contact();
            contact.setContact(name);
            contact.setRoom(room);
            contact.setType(contactTypeService.getById(type));
            contact.setPerson(person);
            contactService.create(contact);
            
            
            model.addAttribute("contactTypes", contactTypeService.getAll());
            model.addAttribute("personForm", service.getById(id));
            model.addAttribute("msg", "Контакт добавлен");
               
            return "admin/person/update?id="+id;
    }
    
    @RequestMapping(params = {"id", "pid"},value = {"/remove"}, method = RequestMethod.GET)
    public String RemoveContact(ModelMap model, @RequestParam(name = "id") Long contactId, @RequestParam(name = "pid") Long personId){
        Contact contact = contactService.getById(contactId);
        contact.setPerson(null);
        contactService.update(contact);
        
        model.addAttribute("contactTypes", contactTypeService.getAll());
        model.addAttribute("personForm", service.getById(personId));
        model.addAttribute("msg", "Контакт удален");
        
        return "admin/person/update?id="+personId; 
    }
    
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public String assignContact(ModelMap model, @RequestParam(name = "pid") Long personId, @RequestParam(name = "assignId") Long contactId){
        Contact contact = contactService.getById(contactId);
        Person person = service.getById(personId);
        
        contact.setPerson(person);
        contactService.update(contact);
        
        model.addAttribute("contactTypes", contactTypeService.getAll());
        model.addAttribute("personForm", service.getById(personId));
        
        return "admin/person/add"; 
    }
    
    //AJAX
    
    @RequestMapping(value = "/ajax/get", method = RequestMethod.GET)
    public @ResponseBody Map getPersonsToAjax(@RequestParam(value = "start") int page, @RequestParam(value = "length") int perPage, @RequestParam(value = "search[value]", required = false, defaultValue = "") String search){
       Map<String, Object> result = new HashMap<>();
       Long count = null; 
       if (!search.equals("")){
           count = service.getCount(search);
        }else{
            count = service.getCount();
        }
         result.put("recordsTotal", count);
         result.put("recordsFiltered", count);
         result.put("data", service.getPersons(page, perPage, search));
        return result;
    }
    
    @RequestMapping(value = "/ajax/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Map getPersonByIdAjax(@PathVariable(value = "id") Long id) throws SQLException{
        Map<String, Object> result = new HashMap<>();
        
        result.put("person", service.getById(id));
        return result;
    }
    
    @RequestMapping(value = "/ajax/update/", method = RequestMethod.PUT)
    public @ResponseBody String updatePerson(@RequestBody Person person){
        Person oldPerson = service.getById(person.getId());
        service.update(person);
        logger.info(LogFormer.createUpdateLogString(oldPerson, person));
        
        
        
        return "success";
    }
    
    @RequestMapping(value = "/ajax/get/image/{id}", method = RequestMethod.GET)
    public @ResponseBody String getImage(@PathVariable(value = "id") Long id){
      return Base64.getEncoder().encodeToString(imageService.getImageByPerson(id));
    }
    
}
