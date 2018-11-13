/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.entity.ContactType;
import com.phones.forms.validators.ContactTypeValidator;
import com.phones.services.contacttype.ContactTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("contacttype")
public class ContactTypeController {
    
    @Autowired
    private ContactTypeService service;
    
    @Autowired
    private ContactTypeValidator validator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }
    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String contactTypeList(ModelMap model){
        model.addAttribute("types", service.getAll());
        return "admin/contacttype";
    }
    
    @RequestMapping(value = {"/addoredit"}, method = RequestMethod.POST)
    public String createOrUpdateType(@ModelAttribute("contacttypeForm") @Validated ContactType type, BindingResult result,
            ModelMap model, final RedirectAttributes redirectAttributes){
        
        if (result.hasErrors()){
            return "admin/contacttype/add";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (type.getId() == null){
                redirectAttributes.addFlashAttribute("msg", "Добавлен новый тип контакта!");
                service.create(type);
            } else {
                redirectAttributes.addFlashAttribute("msg", "Тип контакта обнавлен");
                service.update(type);
            }
            return "redirect:/contacttype";
        }
    }
    
    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addContactTypeForm(ModelMap model){
        ContactType type = new ContactType();
        model.addAttribute("contacttypeForm", type);
        return "admin/contacttype/add";
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET,params = {"id"})
    public String editContactType(@RequestParam("id") Long id, ModelMap model){
        ContactType type = service.getById(id);
        model.addAttribute("contacttypeForm", type);
        return "admin/contacttype/add";
    }
    
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET, params = {"id"})
    public String deleteContactType(@RequestParam("id") Long id, final RedirectAttributes redirectAttributes){
        service.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Тип контакта успешно удален");
        
        return "redirect:/contacttype";
    }
    
    @RequestMapping(value = "ajax/list", method = RequestMethod.GET)
   public @ResponseBody List<ContactType> getContactTypeList(){
       return service.getAll();
   }
    
}
