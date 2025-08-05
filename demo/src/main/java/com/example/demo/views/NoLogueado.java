package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("NoLogueado")
public class NoLogueado extends Inicio {
    // public iNoLogueado _iNoLogueado;
    public Login _login;
    public Registrar _registrar;

    public void Login() {
        throw new UnsupportedOperationException();
    }

    public void Registrar() {
        throw new UnsupportedOperationException();
    }

    public NoLogueado() {
        super(); // Llama al constructor de Inicio para añadir el buscador

        // Botones de Login y Registrar
        // Botón de Login
Button loginButton = new Button("Login", new Icon(VaadinIcon.SIGN_IN));
loginButton.addClickListener(e -> Login());
loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY); // Botón azul

// Botón de Registrar
Button registrarButton = new Button("Registrar", new Icon(VaadinIcon.USER_CARD));
registrarButton.addClickListener(e -> Registrar());
registrarButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS); // Botón verde
        HorizontalLayout botones = new HorizontalLayout(loginButton, registrarButton);
         
		 
        // Añade los botones al final de la vista
        header.add(botones);
    }
}
