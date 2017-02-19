/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.Event;
import com.eventplanner.domain.EventUser;
import com.eventplanner.repo.EventRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * @author DanielB
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private EventGroupService groupService;
    @Autowired
    private EventUserService userService;

    /*
    LocalDateTime is converted in the controller from the HTML localdate object
    GOTO Event class for more info
    Checks for duplicates
    */
    public Event createEvent(String name, Integer groupId, String description, String location,
                             LocalDateTime startDate, LocalDateTime endDate) {
        if (eventRepo.findByNameAndEventGroup(name, groupService.findGroupById(groupId)) == null) {
            return eventRepo.save(new Event(name, groupService.findGroupById(groupId), description, location,
                    startDate, endDate));
        }
        return null;
    }

    public void deleteEvent(Integer eventId) {
        if (eventRepo.exists(eventId)) {
            eventRepo.delete(eventId);
        }
    }

    public void updateEvent(Integer eventId, String name, String description, String location,
                            int startYear, int startMonth, int startDay, int startHour, int startMinute,
                            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        Event event = eventRepo.findOne(eventId);
        event.setEventName(name);
        event.setDescription(description);
        event.setLocation(location);
        event.setStartDate(startYear, startMonth, startDay, startHour, startMinute);
        event.setEndDate(endYear, endMonth, endDay, endHour, endMinute);
        eventRepo.save(event);
    }

    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList();
        eventRepo.findAll().forEach(list::add);
        return list;
    }

    /*
    Adds and removes members uniquely to event and not group
    Checks for duplicates
    */
    public EventUser addMember(Integer eventId, String username) {
        Event event = eventRepo.findOne(eventId);
        EventUser user = userService.findByUsername(username);
        if (user != null) {
            if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))
                    && !event.getEventMemberList().contains(user)) {
                event.getEventMemberList().add(user);
            }
            eventRepo.save(event);
        }
        return user;
    }

    public Event removeMember(Integer eventId, String username) {
        Event event = eventRepo.findOne(eventId);
        event.getEventMemberList().remove(userService.findByUsername(username));
        return eventRepo.save(event);
    }
}
