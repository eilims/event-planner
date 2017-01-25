/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.controller;

import com.eventplanner.domain.EventGroup;
import com.eventplanner.service.EventGroupService;
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
@RequestMapping("/admin/group")
public class EventGroupController {
    @Autowired
    private EventGroupService groupService;

    @PostMapping("/createGroup")
    @ResponseBody
    public EventGroup createGroup(String name) {
        return groupService.createGroup(name);
    }
    
    @PostMapping("/deleteGroup")
    @ResponseBody
    public EventGroup deleteGroup(Integer eventGroupId){
        groupService.deleteGroup(eventGroupId);
        return null;
    }
    
    @PostMapping("/updateGroup")
    @ResponseBody
    public EventGroup updateGroup(Integer eventGroupId, String name){
        return null;
    }
    
    @PostMapping("/findGroup")
    @ResponseBody
    public EventGroup findGroup(String name){
        return groupService.findGroupByName(name);
    }

}
