/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.domain.EventUser;
import com.eventplanner.service.EventUserService;
import com.eventplanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DanielB
 */
@Controller
@RequestMapping("/user")
public class EventUserController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventUserService userService;

    @PostMapping("/createMember")
    @ResponseBody
    public EventUser createMember(String username, String password, String email, String role) {
        return userService.createMember(username, password, email, role);
    }

    @PostMapping("/removeMember")
    @ResponseBody
    public EventUser removeMember(Integer eventId, String username) {
        eventService.removeMember(eventId, username);
        return null;
    }

}
