/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author DanielB
 */

@Controller
public class EventPageController {
    
    @GetMapping("events.html")
    public String showPage(@ModelAttribute("model") ModelMap model){
        model.addAttribute("cookie","anyvalue");
        return "events";
    }
}
