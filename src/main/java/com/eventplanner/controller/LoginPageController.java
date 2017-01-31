/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.service.EventUserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author DanielB
 */
@Controller
public class LoginPageController {
    
    @Autowired
    private EventUserService userService;

    @GetMapping("/login")
    public String showPage(ModelMap model) {
        return "login";
    }

    @GetMapping("/register/user")
    public String showUserRegisterPage(){
        return "user";
    }
    
    @GetMapping("/register/admin")
    public String showAdminRegisterPage(){
        return "admin";
    }
    
    @GetMapping("/home")
    public String showHomePage(@ModelAttribute("model") ModelMap model, Principal principal){
        String username = principal.getName();
        if(userService.findByUsername(username).getAuthorities().contains(new SimpleGrantedAuthority("USER"))){
            model.addAttribute("auth", "USER");
        } else {
            model.addAttribute("auth", "ADMIN");
        }
        return "home";
    }

}
