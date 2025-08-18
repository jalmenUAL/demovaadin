package com.example.demo.views;




import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
@Route("login")
public class Login extends VerticalLayout {

    public Login(AuthenticationManager authManager) {
        LoginOverlay login = new LoginOverlay();
        login.setOpened(true);
        login.setAction(""); // vacío para que Vaadin gestione el login
        add(login);

        login.addLoginListener(event -> {
            try {
                Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        event.getUsername(),
                        event.getPassword()
                    )
                );
                VaadinSession.getCurrent().setAttribute(Authentication.class, auth);
                UI.getCurrent().navigate(auth.getAuthorities().stream()
                        .anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"))
                        ? "administrador"
                        : "youtuber");
            } catch (AuthenticationException e) {
                login.setError(true);
            }
        });
    }
}
