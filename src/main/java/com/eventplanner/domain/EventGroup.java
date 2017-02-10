/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author DanielB
 */
@Entity
public class EventGroup implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    
    /*
    Refer to Events for ManyToMany and JsonBackReference
    
    */
    @ManyToMany
    @JsonBackReference
    private List<EventUser> groupMemberList;

    @ManyToMany
    @JsonBackReference
    private List<EventUser> groupAdminList;
    
    /*
    Group has many incoming events, but events belong to one group => OneToMany
    Mapping is here as the container or parent should hold the mapping.
    JsonManagedReference held here due to mapping
    */
    @OneToMany(mappedBy = "eventGroup")
    @JsonManagedReference
    private List<Event> eventList;

    public EventGroup(String name, EventUser admin) {
        //TODO add initial admin upon instantiation
        this.name = name;
        this.groupMemberList = new ArrayList();
        this.groupAdminList = new ArrayList();
        this.groupAdminList.add(admin);
        this.eventList = new ArrayList();
    }

    protected EventGroup() {

    }

    public Integer getGroupId() {
        return id;
    }

    public String getGroupName() {
        return name;
    }

    public void setGroupName(String name) {
        this.name = name;
    }

    public List<EventUser> getGroupMemberList() {
        return groupMemberList;
    }

    public void setGroupMemberList(List<EventUser> groupMemberList) {
        this.groupMemberList = groupMemberList;
    }

    public List<EventUser> getGroupAdminList() {
        return groupAdminList;
    }

    public void setGroupAdminList(List<EventUser> adminList) {
        this.groupAdminList = adminList;
    }

    public List<Event> getGroupEventList() {
        return eventList;
    }

    public void setGroupEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

}
