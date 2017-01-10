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

    @Column
    private Integer eventGroupId;

    @Column
    private List<Integer> attendeeList;

    public Event(String name, String description, String location,
            int startYear, int startMonth, int startDay, int startHour, int startMinute,
            int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        this.name = name;
        this.startDate = LocalDateTime.of(startYear, startMonth, startDay, startHour, startMinute);
        this.description = description;
        this.location = location;
        this.endDate = LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinute);
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

    public LocalDateTime getDate() {
        return startDate;
    }

    public void setDate(LocalDateTime date) {
        this.startDate = date;

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

    public LocalDateTime getEventDate() {
        return startDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.startDate = eventDate;
    }

    public LocalDateTime getEndTime() {
        return endDate;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endDate = endTime;
    }

    public List<Integer> getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(List<Integer> attendeeList) {
        this.attendeeList = attendeeList;
    }

    public Integer getEventGroupId() {
        return eventGroupId;
    }

    public void setEventGroupId(Integer eventGroupId) {
        this.eventGroupId = eventGroupId;
    }
}
