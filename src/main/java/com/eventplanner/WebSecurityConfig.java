/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventplanner;

import com.eventplanner.service.EventUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author DanielB
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private EventUserDetailsService userDetailService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        This sections specifies access to different pages and authorities
        required. Inaddition to login page redirects and logout.
        Commented out code will later authorize HTTPS at a later date 
        Current Date: 31 January 2017
        */
        http
                .authorizeRequests()
                .antMatchers("/register/**", "/js/**", "/css/**", "/images/**")
                    .permitAll()
                    .antMatchers("/admin/**")
                    .hasAuthority("ADMIN")
                    .antMatchers("/user/**")
                    .hasAuthority("USER")
                    .antMatchers("/developer/**")
                    .hasAuthority("DEVELOPER")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/login?error")
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/home", true)
                    .and()
                    .logout()
                    .permitAll();
//                    .and()
//                .requiresChannel()
//                    .anyRequest()
//                    .requiresSecure();
    }
    
    /*
    configureGlobal sets up spring security, while passwordEncoder gives us a
    softcoded encoder method. note the function call to passwordEncoder function
    in configureGlobal method
    */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    
}
