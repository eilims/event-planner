/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.domain.Event;
import com.eventplanner.service.EventService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DanielB
 */
@RestController
@RequestMapping("/admin/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/createEvent")
    @ResponseBody //Sending data back
    public Event createEvent(String name, Integer groupId, String description, String location,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime endDate) {
        return eventService.createEvent(name, groupId, description, location,
                LocalDateTime.parse(startDate + ":00"), LocalDateTime.parse(endDate + ":00"));
    }

    @PostMapping("/deleteEvent")
    public Event deleteEvent(Integer eventId) {
        eventService.deleteEvent(eventId);
        return null;
    }
    
    @PostMapping("/addMember")
    public Event addMember(Integer eventId, String username){
        return eventService.addMember(eventId, username);
    }
    
    @PostMapping("/removeMember")
    public Event removeMember(Integer eventId, String username){
        return eventService.removeMember(eventId, username);
    }
}
