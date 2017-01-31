/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.domain.EventUser;
import com.eventplanner.service.EventGroupService;
import com.eventplanner.service.EventUserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author DanielB
 */
@Controller
public class EventUserPageController {
    @Autowired
    private EventUserService memberService;
    @Autowired
    private EventGroupService groupService;
    
    @GetMapping("/userPage")
    public String showPage(@ModelAttribute("model") ModelMap model, Principal principal){
        String username = principal.getName();
        EventUser member = memberService.findByUsername(username);
        model.addAttribute("groupList", member.getUserGroupList());
        model.addAttribute("username", member.getUsername());
        model.addAttribute("user", member);
        return "userPage";
    }
    
}