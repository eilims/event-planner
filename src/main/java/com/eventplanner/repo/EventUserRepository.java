/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.repo;

import com.eventplanner.domain.EventUser;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DanielB
 */
public interface EventUserRepository extends CrudRepository<EventUser, Integer>{
    EventUser findByUsername(String username);
    
}
