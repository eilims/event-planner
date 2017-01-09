/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.domain.Event;
import com.eventplanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DanielB
 */

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    private EventService eventService;
    
    @PostMapping //For a post 
    @ResponseBody //Sending data back
    public Event createEvent(String name, int year, int month, int day, int hour, int minute){
        return eventService.createEvent(name, year, month, day, hour, minute); 
    }
    
}
