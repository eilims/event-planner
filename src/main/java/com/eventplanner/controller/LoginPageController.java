/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DanielB
 */
@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String showPage(ModelMap model) {
        return "login";
    }

    @GetMapping("/registerUser")
    public String showUserRegisterPage(){
        return "registerUser";
    }
    
    @GetMapping("/registerAdmin")
    public String showAdminRegisterPage(){
        return "registerAdmin";
    }

}
