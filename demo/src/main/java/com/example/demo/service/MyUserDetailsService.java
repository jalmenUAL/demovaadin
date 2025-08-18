package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.builder()
                .username("admin")
                .password(new BCryptPasswordEncoder().encode("1234"))
                .roles("ADMINISTRADOR")
                .build();
        }
        return User.builder()
            .username("user")
            .password(new BCryptPasswordEncoder().encode("1234"))
            .roles("YOUTUBER")
            .build();
    }
}
