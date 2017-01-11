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

/**
 *
 * @author DanielB
 */
@Entity
public class EventMember implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String username;

    @ElementCollection
    private List<Integer> eventIdList;

    @ElementCollection
    private List<Integer> groupIdList;

    public EventMember(String username) {
        this.username = username;
        eventIdList = null;
        groupIdList = null;
    }
    
    protected EventMember(){
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getEventIdList() {
        return eventIdList;
    }

    public void setEventIdList(List<Integer> eventIdList) {
        this.eventIdList = eventIdList;
    }

    public List<Integer> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Integer> groupIdList) {
        this.groupIdList = groupIdList;
    }

}
