/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.Event;
import com.eventplanner.repo.EventRepository;
import java.util.ArrayList;
import java.util.List;
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

    public Event createEvent(String name, int year, int month, int day, int hour, int minute) {
        return eventRepo.save(new Event(name, year, month, day, hour, minute));
    }

    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList();
        eventRepo.findAll().forEach(list::add);
        return list;
    }

    public void deleteEvent(Integer eventId) {
        eventRepo.delete(eventId);
    }
}
