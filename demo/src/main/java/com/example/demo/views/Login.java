package com.example.demo.views;




import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinServletResponse;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Route("login")
@AnonymousAllowed
public class Login extends VerticalLayout {

    private final AuthenticationManager authenticationManager;

    public Login(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setTitle("Mi aplicación");
        loginOverlay.setDescription("Inicia sesión con tus credenciales");
        loginOverlay.setOpened(true);


        loginOverlay.addLoginListener(event -> {
            try {
                Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        event.getUsername(), event.getPassword())
                );

                // 1) Poner el Authentication en el SecurityContext
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(auth);
                SecurityContextHolder.setContext(context);

                // 2) Guardarlo en la HttpSession (para siguientes peticiones)
                HttpServletRequest req = ((VaadinServletRequest) VaadinService.getCurrentRequest()).getHttpServletRequest();
                HttpServletResponse res = ((VaadinServletResponse) VaadinService.getCurrentResponse()).getHttpServletResponse();
                new HttpSessionSecurityContextRepository().saveContext(context, req, res);

                // 3) Navega según rol o recarga la página para re-evaluar accesos
                if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"))) {
                    UI.getCurrent().navigate(Administrador.class);
                } else {
                    UI.getCurrent().navigate(Youtuber.class);
                }
                // Opcional: forzar recarga si tu app chequea permisos en beforeEnter
                // UI.getCurrent().getPage().reload();

            } catch (AuthenticationException e) {
                loginOverlay.setError(true);
                Notification.show("Usuario o contraseña incorrectos", 3000, Notification.Position.MIDDLE);
            }
        });

        add(loginOverlay);
    }
}