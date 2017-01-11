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

    public Event createEvent(String name, String description, String location,
            int startYear, int startMonth, int startDay, int startHour, int startMinute,
            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        return eventRepo.save(new Event(name, description, location,
                startYear, startMonth, startDay, startHour, startMinute,
                endYear, endMonth, endDay, endHour, endMinute));
    }

    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList();
        eventRepo.findAll().forEach(list::add);
        return list;
    }

    public void deleteEvent(Integer eventId) {
        eventRepo.delete(eventId);
    }

    public void addMember(Integer eventId, Integer memberId) {
        //Temporary test method
        Event event = eventRepo.findOne(eventId);
        event.getAttendeeList().add(memberId);
        eventRepo.save(event);
    }

    public void updateEvent(Integer eventId, String name, String description, String location,
            int startYear, int startMonth, int startDay, int startHour, int startMinute,
            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        Event event = eventRepo.findOne(eventId);
        event.setName(name);
        event.setDescription(description);
        event.setLocation(location);
        event.setStartDate(startYear, startMonth, startDay, startHour, startMinute);
        event.setEndDate(endYear, endMonth, endDay, endHour, endMinute);
        eventRepo.save(event);
    }
}
