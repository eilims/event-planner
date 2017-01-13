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

    public void createGroup(String name) {
        //Ensures no duplicate named groups
        if (groupRepo.findByName(name) == null) {
            groupRepo.save(new EventGroup(name));
        }
    }

    public List getAllGroups() {
        List<EventGroup> list = new ArrayList();
        groupRepo.findAll().forEach(list::add);
        return list;
    }

    public EventGroup findGroup(Integer id) {
        return groupRepo.findOne(id);
    }

}
