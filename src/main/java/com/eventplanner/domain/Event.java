/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    private LocalDateTime eventDate;

    public Event(String name, int year, int month, int day, int hour, int minute) {
        this.name = name;
        this.eventDate = LocalDateTime.of(year, month, day, hour, minute);
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
        return eventDate;
    }

    public void setDate(LocalDateTime date) {
        this.eventDate = date;

    }

}
