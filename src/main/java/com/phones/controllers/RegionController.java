/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.controllers;

import com.phones.entity.Regions;
import com.phones.forms.validators.RegionsValidator;
import com.phones.services.regions.RegionsService;
import java.util.HashMap;
import java.util.Map;
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
@RequestMapping("regions")
public class RegionController {
    
    @Autowired
    private RegionsService regionsService;
    
    @Autowired
    private RegionsValidator regionsValidator; 
    
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(regionsValidator);
    }
    
    
    @RequestMapping(params = {"page"}, value = {""}, method = RequestMethod.GET)
    public String regionsList(ModelMap model, @RequestParam("page") int id){
        model.addAttribute("regions", regionsService.getPerPage(id, 50));
        model.addAttribute("curentPage", id);
        model.addAttribute("maxPage", Math.floor(regionsService.getCount()/10));
        return "admin/regions";
    }
    
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String regionsList(ModelMap model){
        model.addAttribute("regions", regionsService.getPerPage(0, 10));
        model.addAttribute("curentPage", 1);
        model.addAttribute("maxPage", Math.floor(regionsService.getCount()/10));
        return "admin/regions";
    }
    
    @RequestMapping(value = {"/addoredit"}, method = RequestMethod.POST)
    public String createOrUpdateRegion(@ModelAttribute("regionForm") @Validated Regions reg, BindingResult result, 
            ModelMap model, final RedirectAttributes redirectAttributes){
       
        if (result.hasErrors()){
            return "admin/regions/add";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (reg.getId() == null){
                redirectAttributes.addFlashAttribute("msg", "Добавлен новый регион!");
                regionsService.create(reg);
            } else{
                redirectAttributes.addFlashAttribute("msg", "Регион был обнавлен");
                regionsService.update(reg);
            }
            return "redirect:/regions";
        }
    }
    
    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addRegionForm(ModelMap model){
        Regions reg = new Regions();
        model.addAttribute("regionForm",reg);
        return "admin/regions/add";
    }
    
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET,params = {"id"})
    public String editRegion(@RequestParam("id") Long id, ModelMap model){
        Regions reg = regionsService.getById(id);
        model.addAttribute("regionForm", reg);
        return "admin/regions/add";
    }
    
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET, params = {"id"})
    public String deleteRegion(@RequestParam("id") Long id, final RedirectAttributes redirectAttributes){
        regionsService.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Регион успешно удален");
        
        return "redirect:/regions";
    }
    
    //AJAX
    
    @RequestMapping(value = "/ajax/get", method = RequestMethod.GET)
    public @ResponseBody Map getPersonsToAjax(@RequestParam(value = "start") int page, @RequestParam(value = "length") int perPage, @RequestParam(value = "search[value]", required = false, defaultValue = "") String search){
       Map<String, Object> result = new HashMap<>();
        if (!search.equals("")){
           Long count = regionsService.getCount(search);
           result.put("recordsTotal", count);
           result.put("recordsFiltered", count);
           result.put("data", regionsService.getPerPage(page, perPage, search));
           
       }else{
            Long count = regionsService.getCount();
            result.put("recordsTotal", count);
            result.put("recordsFiltered", count);
            result.put("data", regionsService.getPerPage(page, perPage));
       }
        return result;
    }
    
}
