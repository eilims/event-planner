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
    private EventUserRepository memberRepo;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        if (memberRepo.findByUsername(string) != null) {
            return buildUser(memberRepo.findByUsername(string));
        }
        throw new UsernameNotFoundException("User not found");
    }

    public User buildUser(EventUser member) {
        return new User(member.getUsername(),
                member.getPassword(),
                true, true, true, true,
                member.getAuthorities());
    }
}
