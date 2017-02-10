/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DanielB
 */
@Controller
@RequestMapping("/developer")
public class EventPageController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events.html")
    public String showPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("eventList", eventService.getAllEvents());
        return "events";
    }

}
