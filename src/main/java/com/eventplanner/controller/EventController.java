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
    public Event createEvent(String name, String description, String location,
            int startYear, int startMonth, int startDay, int startHour, int startMinute,
            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        return eventService.createEvent(name, description, location,
                startYear, startMonth, startDay, startHour, startMinute,
                endYear, endMonth, endDay, endHour, endMinute);
    }

}
