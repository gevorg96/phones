/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.entity.OrganizationType;
import com.phones.forms.validators.OrganizationTypeValidator;
import com.phones.services.organizationtype.OrganizationTypeService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author trunov_as
 */
@Controller
@RequestMapping("organizationtype")
public class OrganizationTypeController {
    
    @Autowired
    private OrganizationTypeService service;
    
    @Autowired
    private OrganizationTypeValidator validator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }
    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String organizationTypeList(ModelMap model){
        model.addAttribute("types", service.getAll());
        return "admin/organizationtype";
    }
    
    @RequestMapping(value = {"/addoredit"}, method = RequestMethod.POST)
    public String createOrUpdateType(@ModelAttribute("organizationtypeForm") @Validated OrganizationType type, BindingResult result,
            ModelMap model, final RedirectAttributes redirectAttributes){
        
        if (result.hasErrors()){
            return "admin/organizationtype/add";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (type.getId() == null){
                redirectAttributes.addFlashAttribute("msg", "Добавлен новый тип организации!");
                service.create(type);
            } else {
                redirectAttributes.addFlashAttribute("msg", "Тип организации обнавлен");
                service.update(type);
            }
            return "redirect:/organizationtype";
        }
    }
    
    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addOrganizationTypeForm(ModelMap model){
        OrganizationType type = new OrganizationType();
        model.addAttribute("organizationtypeForm", type);
        return "admin/organizationtype/add";
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET,params = {"id"})
    public String editOrganizationType(@RequestParam("id") Long id, ModelMap model){
        OrganizationType type = service.getById(id);
        model.addAttribute("organizationtypeForm", type);
        return "admin/organizationtype/add";
    }
    
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET, params = {"id"})
    public String deleteOrganizationType(@RequestParam("id") Long id, final RedirectAttributes redirectAttributes){
        service.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Тип организации успешно удален");
        
        return "redirect:/organizationtype";
    }
    
}
