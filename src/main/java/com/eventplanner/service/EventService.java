/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.Event;
import com.eventplanner.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DanielB
 */

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepo;
    
    public Event createEvent(String name){
        return eventRepo.save(new Event(name));
    }
}
