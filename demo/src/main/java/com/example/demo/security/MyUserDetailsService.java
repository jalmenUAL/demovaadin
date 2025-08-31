package com.example.demo.security;

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
        // 👇 Aquí puedes consultar la BD, de momento hardcodeamos
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password(new BCryptPasswordEncoder().encode("1234"))
                    .roles("ADMINISTRADOR")
                    .build();
        }
        if ("youtuber".equals(username)) {
            return User.withUsername("youtuber")
                    .password(new BCryptPasswordEncoder().encode("1234"))
                    .roles("YOUTUBER")
                    .build();
        }
        throw new UsernameNotFoundException("Usuario no encontrado");

    }
}
