/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @ElementCollection
    private List<Integer> memberList;

    @ElementCollection
    private List<Integer> adminList;

    @OneToMany
    private List<Event> eventList;

    public EventGroup(String name) {
        //TODO add initial admin upon instantiation
        this.name = name;
    }
    
    protected EventGroup(){
        
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

    public List<Integer> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Integer> memberList) {
        this.memberList = memberList;
    }

    public List<Integer> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Integer> adminList) {
        this.adminList = adminList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

}
