/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.EventMember;
import com.eventplanner.repo.EventMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DanielB
 */
@Service
public class EventMemberService {
    @Autowired
    private EventMemberRepository memberRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public EventMember createMember(String username, String password, String email) {
        return memberRepo.save(new EventMember(username, passwordEncoder.encode(password), email));
    }
}
