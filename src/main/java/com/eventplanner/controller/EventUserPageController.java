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
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author DanielB
 */
@Controller
public class EventUserPageController {

    @Autowired
    private EventUserService userService;
    @Autowired
    private EventGroupService groupService;

    @GetMapping("/user/userPage")
    public String showPage(@ModelAttribute("model") ModelMap model, Principal principal) {
        String username = principal.getName();
        EventUser user = userService.findByUsername(username);
        model.addAttribute("groupList", user.getUserGroupList());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("enabled", user.isEnabled());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("id", user.getId());
        return "userPage";
    }

    @GetMapping("/admin/adminPage")
    public String showAdminPage(@ModelAttribute("model") ModelMap model, Principal principal) {
        EventUser admin = userService.findByUsername(principal.getName());
        model.addAttribute("username", admin.getUsername());
        model.addAttribute("groupList", admin.getUserAdminList());
        model.addAttribute("enabled", admin.isEnabled());
        model.addAttribute("email", admin.getEmail());
        model.addAttribute("id", admin.getId());
        return "adminPage";
    }

    @GetMapping("/register/{id}")
    public String showConfirmationPage(@ModelAttribute("model") ModelMap model, @PathVariable Integer id) {
        model.addAttribute("id", id);
        if (!userService.checkEnabled(id)) {
            model.addAttribute("activated", true);
            return "confirmation";
        } else {
            model.addAttribute("activated", false);
            return "confirmation";
        }

    }
}
