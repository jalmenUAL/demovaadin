package com.example.demo.views;



import com.example.demo.service.iNoLogueado;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.UIScope;
import com.example.demo.domain.Registrado;
import com.example.demo.domain.Administrador;
import com.example.demo.domain.Youtuber;
 

@Route("Login")
@AnonymousAllowed
public class Login extends VerticalLayout {

    private LoginOverlay loginOverlay;

    public Login(iNoLogueado iNoLogueado) {
        loginOverlay = new LoginOverlay();
        loginOverlay.setOpened(true);  
        loginOverlay.setTitle("Youtube");
        loginOverlay.setDescription("Por favor inicia sesión");
        loginOverlay.setAction("Login");  

         
        loginOverlay.setForgotPasswordButtonVisible(false);

        add(loginOverlay);
        loginOverlay.addLoginListener(event -> {
            // Aquí puedes manejar el evento de inicio de sesión
            // Por ejemplo, autenticar al usuario y redirigir a la página principal
            Registrado r = iNoLogueado.Login(event.getUsername(), event.getPassword());
            if (r instanceof Administrador) {
                VaadinSession.getCurrent().setAttribute(com.example.demo.domain.Registrado.class, r);
                UI.getCurrent().navigate(com.example.demo.views.Inicio.class);
            } else if (r instanceof Youtuber) {
                VaadinSession.getCurrent().setAttribute(com.example.demo.domain.Registrado.class, r);
                UI.getCurrent().navigate(com.example.demo.views.Inicio.class);
            } else 
                {
                Notification.show("Usuario o contraseña incorrectos", 3000, Notification.Position.MIDDLE);
                UI.getCurrent().navigate(com.example.demo.views.Inicio.class);
                }
        });

    }
}
