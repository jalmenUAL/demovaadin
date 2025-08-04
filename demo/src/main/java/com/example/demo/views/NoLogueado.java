package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
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
        Button loginButton = new Button("Login", e -> Login());
        Button registrarButton = new Button("Registrar", e -> Registrar());
        HorizontalLayout botones = new HorizontalLayout(loginButton, registrarButton);
        botones.addClassName(LumoUtility.Padding.Horizontal.MEDIUM);

        // Añade los botones al final de la vista
        add(botones);
    }
}
