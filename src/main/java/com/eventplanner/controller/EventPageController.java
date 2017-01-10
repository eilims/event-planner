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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DanielB
 */
@Controller
public class EventPageController {

    @Autowired
    private EventService eventService;

    @GetMapping("events.html")
    public String showPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("eventList", eventService.getAllEvents());
        return "events";
    }

    @PostMapping("createEvent") //For a post 
    public String createEvent(String name, String description, String location,
            int startYear, int startMonth, int startDay, int startHour, int startMinute,
            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        eventService.createEvent(name, description, location,
                startYear, startMonth, startDay, startHour, startMinute,
                endYear, endMonth, endDay, endHour, endMinute);
        return "redirect:/events.html";
    }

    @PostMapping("deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events.html";
    }
    
    @PostMapping("addMember/{eventId}")
    public String addMember(@PathVariable Integer eventId, Integer memberId){
        eventService.addMember(eventId, memberId);
        return "redirect:/events.html";
    }
}
