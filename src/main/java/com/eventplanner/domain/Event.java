/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    @Column
    private LocalDateTime startDate;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private LocalDateTime endDate;

    @ManyToOne
    private EventGroup eventGroup;

    @ManyToMany 
    private List<EventMember> memberList;

    public Event(String name, EventGroup eventGroup, String description, String location,
            LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.description = description;
        this.location = location;
        this.endDate = endDate;
        this.eventGroup = eventGroup;
    }

    protected Event() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public List<EventMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<EventMember> attendeeList) {
        this.memberList = attendeeList;
    }

    public EventGroup getEventGroup() {
        return eventGroup;
    }

    public void setEventGroup(EventGroup eventGroup) {
        this.eventGroup = eventGroup;
    }
}
