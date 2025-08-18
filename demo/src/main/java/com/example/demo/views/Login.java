package com.example.demo.views;




import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
@Route("login")
public class Login extends VerticalLayout {

    private final AuthenticationManager authenticationManager;

    public Login(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        Notification.show("Holi");

        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setTitle("Mi aplicación");
        loginOverlay.setDescription("Inicia sesión con tus credenciales");
        loginOverlay.setOpened(true);

        
        loginOverlay.addLoginListener(event -> {
            try {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                event.getUsername(),
                                event.getPassword()
                        )
                );

                VaadinSession.getCurrent().setAttribute(Authentication.class, auth);

                if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"))) {
                    UI.getCurrent().navigate(Administrador.class);
                } else {
                    UI.getCurrent().navigate(Youtuber.class);
                }

            } catch (AuthenticationException e) {
                loginOverlay.setError(true);
            }
        });

        add(loginOverlay);
    }
        
}

