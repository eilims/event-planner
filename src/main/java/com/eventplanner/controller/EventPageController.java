/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.service.EventService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @PostMapping("createEvent/{eventGroupId}") //For a post 
    public String createEvent(String name, @PathVariable Integer eventGroupId, String description, String location,
            String startDate,String endDate) {
        eventService.createEvent(name, eventGroupId, description, location,
                LocalDateTime.parse(startDate + ":00"), LocalDateTime.parse(endDate + ":00"));
        return "redirect:/events.html";
    }

    @PostMapping("deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events.html";
    }

    @PostMapping("addMember/{eventId}")
    public String addMember(@PathVariable Integer eventId, Integer memberId) {
        eventService.addMember(eventId, memberId);
        return "redirect:/events.html";
    }

    @PostMapping("updateEvent/{eventId}")
    public String updateEvent(@PathVariable Integer eventId, String name, String description, String location,
            int startYear, int startMonth, int startDay, int startHour, int startMinute,
            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        eventService.updateEvent(eventId, name, description, location,
                startYear, startMonth, startDay, startHour, startMinute,
                endYear, endMonth, endDay, endHour, endMinute);
        return "redirect:/event.html";
    }
}
