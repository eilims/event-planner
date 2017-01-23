/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.EventMember;
import com.eventplanner.repo.EventMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author DanielB
 */
@Service
public class EventMemberDetailsService implements UserDetailsService {
    @Autowired
    private EventMemberRepository memberRepo;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        if (memberRepo.findByUsername(string) != null) {
            return buildUser(memberRepo.findByUsername(string));
        }
        throw new UsernameNotFoundException("User not found");
    }

    public User buildUser(EventMember member) {
        return new User(member.getUsername(),
                member.getPassword(),
                true, true, true, true,
                member.getAuthorities());
    }
}
