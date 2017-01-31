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
import javax.persistence.ElementCollection;
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

    @ManyToMany
    @JsonBackReference
    private List<EventUser> groupMemberList;

    @ElementCollection
    private List<Integer> adminList;

    @OneToMany(mappedBy="eventGroup")
    @JsonManagedReference
    private List<Event> eventList;

    public EventGroup(String name) {
        //TODO add initial admin upon instantiation
        this.name = name;
        this.groupMemberList = new ArrayList();
        this.adminList = new ArrayList();
        this.eventList = new ArrayList();
    }
    
    protected EventGroup(){
        
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

    public List<Integer> getGroupAdminList() {
        return adminList;
    }

    public void setGroupAdminList(List<Integer> adminList) {
        this.adminList = adminList;
    }

    public List<Event> getGroupEventList() {
        return eventList;
    }

    public void setGroupEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

}
