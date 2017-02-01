/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.service;

import com.eventplanner.domain.EventGroup;
import com.eventplanner.domain.EventUser;
import com.eventplanner.repo.EventGroupRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author DanielB
 */
@Service
public class EventGroupService {

    @Autowired
    private EventGroupRepository groupRepo;
    @Autowired
    private EventUserService userService;

    /*
        createGroup ensures that no duplicate named groups are possible
     */
    public EventGroup createGroup(String name) {
        if (groupRepo.findByName(name) == null) {
            return groupRepo.save(new EventGroup(name));
        }
        return null;
    }

    /*
        deleteGroup ensured that the group exists before deleting 
     */
    public void deleteGroup(Integer eventGroupId) {
        if (groupRepo.exists(eventGroupId)) {
            groupRepo.delete(eventGroupId);
        }
    }

    /*
        getAllGroups was used for testing groups.ftl
        Not to be used for any published builds
     */
    public List getAllGroups() {
        List<EventGroup> list = new ArrayList();
        groupRepo.findAll().forEach(list::add);
        return list;
    }

    public EventGroup findGroupById(Integer id) {
        return groupRepo.findOne(id);
    }

    public EventGroup findGroupByName(String name) {
        return groupRepo.findByName(name);
    }

    /*
    SimpleGrantedAuthority is the object used by Spring User, as such EventUser
    implements UserDetails and uses SPA. It is essentially a String container
    Method also checks for duplicates and prevents it
     */
    public EventGroup addMember(Integer groupId, String name) {
        EventGroup group = groupRepo.findOne(groupId);
        EventUser user = userService.findByUsername(name);
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))
                && !group.getGroupMemberList().contains(user)) {
            group.getGroupMemberList().add(user);
        }
        groupRepo.save(group);
        return group;
    }

    public EventGroup removeMember(Integer groupId, String name) {
        EventGroup group = groupRepo.findOne(groupId);
        group.getGroupMemberList().remove(userService.findByUsername(name));
        groupRepo.save(group);
        return group;
    }

}
