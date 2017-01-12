/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.service.EventGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DanielB
 */
@Controller
public class EventGroupPageController {
    @Autowired
    private EventGroupService groupService;
    
    @GetMapping("groups.html")
    public String showPage(@ModelAttribute("model") ModelMap model){
        model.addAttribute("groupList", groupService.getAllGroups());
        return "groups";
    }
    
    @PostMapping("createGroup")
    public String createGroup(String name){
        groupService.createGroup(name);
        return "redirect:/groups.html";
    }
    
}
