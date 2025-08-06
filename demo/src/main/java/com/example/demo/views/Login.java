package com.example.demo.views;



import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

 

@Route("Login")
@AnonymousAllowed
public class Login extends VerticalLayout {

    private LoginOverlay loginOverlay;

    public Login() {
        loginOverlay = new LoginOverlay();
        loginOverlay.setOpened(true);  
        loginOverlay.setTitle("Youtube");
        loginOverlay.setDescription("Por favor inicia sesión");
        loginOverlay.setAction("Login");  

         
        loginOverlay.setForgotPasswordButtonVisible(false);

        add(loginOverlay);
    }
}
