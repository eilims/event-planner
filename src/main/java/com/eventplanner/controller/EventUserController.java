/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.domain.EventUser;
import com.eventplanner.service.EventGroupService;
import com.eventplanner.service.EventUserService;
import com.eventplanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DanielB
 */
@Controller
public class EventUserController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventUserService userService;
    @Autowired
    private EventGroupService groupService;

    /*
    Method is boolean to ensure user creation
    True implies a created user
    False implies the username is already in use
     */
    @PostMapping("/register/createMember")
    @ResponseBody
    public boolean createMember(String username, String password, String email, String role) {
        return userService.createMember(username, password, email, role) != null;
    }

    @PostMapping("/user/leaveEvent")
    @ResponseBody
    public EventUser leaveEvent(Integer eventId, String username) {
        eventService.removeMember(eventId, username);
        return null;
    }
    
    @PostMapping("/user/leaveGroup")
    @ResponseBody
    public EventUser leaveGroup(Integer groupId, String username) {
        groupService.removeMember(groupId, username);
        return null;
    }

}
