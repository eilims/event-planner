/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.repo;

import com.eventplanner.domain.Event;
import com.eventplanner.domain.EventGroup;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DanielB
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findByIdAndEventGroup(Integer id, EventGroup eventGroup);
}
