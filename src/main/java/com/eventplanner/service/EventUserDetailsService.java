/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.EventUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.eventplanner.repo.EventUserRepository;

/**
 *
 * @author DanielB
 */
@Service
public class EventUserDetailsService implements UserDetailsService {
    @Autowired
    private EventUserRepository userRepo;

    /*
    Implements UserDetailsService to ensure proper interface with spring security
    */
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        if (userRepo.findByUsername(string) != null) {
            return buildUser(userRepo.findByUsername(string));
        }
        throw new UsernameNotFoundException("User not found");
    }
    
    /*
    Converts EventUser into Spring security User
    */
    public User buildUser(EventUser user) {
        return new User(user.getUsername(),
                user.getPassword(),
                true, true, true, true,
                user.getAuthorities());
    }
}
