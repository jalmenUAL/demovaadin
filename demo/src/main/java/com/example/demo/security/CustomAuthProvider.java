package com.example.demo.security;

import java.util.Collections;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Registrado;
import com.example.demo.service.iNoLogueado;
import com.vaadin.flow.component.notification.Notification;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private final iNoLogueado iNoLogueado;

    public CustomAuthProvider(@Lazy iNoLogueado iNoLogueado) {
        this.iNoLogueado = iNoLogueado;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

         

        // 🔹 Aquí usas tu método
        Registrado r = iNoLogueado.Login(username, password);
        


        if (r == null) {
            throw new UsernameNotFoundException("Usuario o contraseña incorrectos");
        }

        String role;
    if (r instanceof com.example.demo.domain.Administrador) {
        role = "ROLE_ADMINISTRADOR";

    } else if (r instanceof com.example.demo.domain.Youtuber) {
        role = "ROLE_YOUTUBER";
         

    } else {
        role = "ROLE_REGISTRADO"; // fallback genérico
    }

    

    return new UsernamePasswordAuthenticationToken(
            r, // principal = tu entidad de dominio
            r.getPassword(),
            Collections.singletonList(() -> role)
    );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

