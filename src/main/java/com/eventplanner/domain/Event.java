/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author DanielB
 */
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    /*
    LocalDateTime is an object which contains a time and date, not the generic
    java datetime.
    Saves a lot of effort when coding. Superior to Java's DateTime
    Can be passed to freemarker easily, and contains methods to split date and time
    */
    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private String description;

    @Column
    private String location;

    /*
    Many events go to one group. Events can belong to one group. ManyToOne :)
    
    JsonBackReference is given to the object that does not have the mapping
    (called the back reference). The opposite of this is the JsonManagedReference
    These annotiations are added are to prevent a recursive access to one another 
    when saving. I.E. stackoverflow error.
    */
    @ManyToOne
    @JsonBackReference
    private EventGroup eventGroup;

    /*
    Users can be in many events and many events to different users => 
    ManyToMany
    Note the back reference and lack of mapping
    */
    @ManyToMany
    @JsonBackReference
    private List<EventUser> eventMemberList;

    public Event(String name, EventGroup eventGroup, String description, String location,
            LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.description = description;
        this.location = location;
        this.endDate = endDate;
        this.eventGroup = eventGroup;
        this.eventMemberList = new ArrayList();
        eventGroup.getGroupMemberList().forEach(this.eventMemberList::add);
    }

    protected Event() {

    }

    public Integer getEventId() {
        return id;
    }

    public String getEventName() {
        return name;
    }

    public void setEventName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(int year, int month, int day, int hour, int minute) {
        this.startDate = LocalDateTime.of(year, month, day, hour, minute);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(int year, int month, int day, int hour, int minute) {
        this.endDate = LocalDateTime.of(year, month, day, hour, minute);
    }

    public List<EventUser> getEventMemberList() {
        return eventMemberList;
    }

    public void setEventMemberList(List<EventUser> attendeeList) {
        this.eventMemberList = attendeeList;
    }

    public EventGroup getEventGroup() {
        return eventGroup;
    }

    public void setEventGroup(EventGroup eventGroup) {
        this.eventGroup = eventGroup;
    }
}
