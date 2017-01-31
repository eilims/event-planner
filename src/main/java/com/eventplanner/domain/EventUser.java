/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author DanielB
 */
@Entity
public class EventUser implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private boolean enabled;

    @Column
    private boolean accountNonExpired;

    @Column
    private boolean accountNonLocked;

    @Column
    private boolean credentialsNonExpired;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<GrantedAuthority> authorities;
    
    @ManyToMany (mappedBy = "eventMemberList")
    @JsonManagedReference
    private List<Event> userEventList;
    
    @ManyToMany (mappedBy = "groupMemberList")
    @JsonManagedReference
    private List<EventGroup> userGroupList;

    public EventUser(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.authorities  = new HashSet();
        authorities.add(new SimpleGrantedAuthority(role));
    }

    protected EventUser() {

    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return authorities; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return password; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername() {
        return username; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        return enabled; //To change body of generated methods, choose Tools | Templates.
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public List<Event> getUserEventList() {
        return userEventList;
    }

    public void setUserEventList(List<Event> eventList) {
        this.userEventList = eventList;
    }

    public List<EventGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<EventGroup> groupList) {
        this.userGroupList = groupList;
    }

}
