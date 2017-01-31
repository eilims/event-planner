/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.EventUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.eventplanner.repo.EventUserRepository;

/**
 *
 * @author DanielB
 */
@Service
public class EventUserService {
    @Autowired
    private EventUserRepository memberRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public EventUser createMember(String username, String password, String email, String role) {
        return memberRepo.save(new EventUser(username, passwordEncoder.encode(password), email, role));
    }
    
    public EventUser findByUsername(String name){
        return memberRepo.findByUsername(name);
    }
    
        public List<EventUser> getAllMembers() {
        List<EventUser> memList = new ArrayList();
        memberRepo.findAll().forEach(item -> {
            if(!item.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")))
            {
                memList.add(item);
            }
        });
        
        return memList;
    }
}
