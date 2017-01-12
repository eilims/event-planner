/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.repo;

import com.eventplanner.domain.EventGroup;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DanielB
 */
public interface EventGroupRepository extends CrudRepository<EventGroup, Integer>{
    EventGroup findByName(String name);
}
