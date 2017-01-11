/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.EventMember;
import com.eventplanner.repo.EventMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DanielB
 */
@Service
public class EventMemberService {
    @Autowired
    private EventMemberRepository memberRepo;
    
    public EventMember createMember(String username){
        return memberRepo.save(new EventMember(username));
    }
}
