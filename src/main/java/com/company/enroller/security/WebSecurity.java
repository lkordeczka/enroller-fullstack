package com.company.enroller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeRequests()
               .anyRequest().permitAll() // Pozwala wysłać zapytania do serwera domyślnie zabezpieczone 
               .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   }
   @Autowired
   ParticipantProvider participantProvider;
   
   @Autowired
   PasswordEncoder passwordEncoder;
   
   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(participantProvider).passwordEncoder(passwordEncoder);
   }
}
