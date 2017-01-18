/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.Event;
import com.eventplanner.domain.EventGroup;
import com.eventplanner.repo.EventGroupRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DanielB
 */
@Service
public class EventGroupService {

    @Autowired
    private EventGroupRepository groupRepo;

    public EventGroup createGroup(String name) {
        //Ensures no duplicate named groups
        if (groupRepo.findByName(name) == null) {
            return groupRepo.save(new EventGroup(name));
        }
        return null;
    }
    
    public void deleteGroup(Integer eventGroupId){
        if(groupRepo.exists(eventGroupId)){
            groupRepo.delete(eventGroupId);
        }
    }

    public List getAllGroups() {
        List<EventGroup> list = new ArrayList();
        groupRepo.findAll().forEach(list::add);
        return list;
    }

    public EventGroup findGroupById(Integer id) {
        return groupRepo.findOne(id);
    }
    
    public EventGroup findGroupByName(String name){
        return groupRepo.findByName(name);
    }

}
