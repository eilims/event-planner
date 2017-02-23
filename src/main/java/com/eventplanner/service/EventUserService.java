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
    private EmailService emailService;

    @Autowired
    private EventUserRepository userRepo;
    /*
    PasswordEncoder encypts password using BCrypt more can be found in UserDetailsService
    */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
    Ensured no duplicate named users
    add error send back
    */
    public EventUser createMember(String username, String password, String email, String role) {
        if (userRepo.findByUsername(username) == null) {
            emailService.sendVerificationEmail(email);
            return userRepo.save(new EventUser(username, passwordEncoder.encode(password), email, role));
        }
        return null;
    }
    
    public void deleteMember(Integer userId){
        if(userRepo.exists(userId)){
            userRepo.delete(userId);
        }
    }

    public EventUser findByUsername(String name) {
        return userRepo.findByUsername(name);
    }

    /*
    Used for search page
    To be heavily modified (add group filtering
    */
    public List<EventUser> getAllMembers() {
        List<EventUser> memList = new ArrayList();
        userRepo.findAll().forEach(item -> {
            if (!item.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                memList.add(item);
            }
        });
        return memList;
    }
}
