/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import java.io.Serializable;
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

    public Event(String name) {
        this.name = name;
    }
    
    protected Event(){
        
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
    
    
    
    
}
