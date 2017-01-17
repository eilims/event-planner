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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DanielB
 */
@RestController
@RequestMapping("createEvent")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("createEvent")
    @ResponseBody //Sending data back
    public Event createEvent(String name, Integer eventGroupId, String description, String location,
            LocalDateTime startDate, LocalDateTime endDate) {
        return eventService.createEvent(name, eventGroupId, description, location,
                LocalDateTime.parse(startDate + ":00"), LocalDateTime.parse(endDate + ":00"));
    }

}
