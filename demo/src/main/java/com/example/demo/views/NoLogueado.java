package com.example.demo.views;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.iInicio;
import com.example.demo.service.iNoLogueado;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("NoLogueado")
public class NoLogueado extends Inicio {
    public iNoLogueado _iNoLogueado;
    public Login _login;
    public Registrar _registrar;

    public void Login() {
        UI.getCurrent().navigate(Login.class);
    }

    public void Registrar() {
        UI.getCurrent().navigate(Registrar.class);
    }

    public NoLogueado(RepositorioVideo videorepository,
		RepositorioYoutuber youtuberRepository,
		RepositorioComentario comentariosRepository,
		RepositorioAdministrador administradoresRepository) {
        super(videorepository, youtuberRepository, comentariosRepository, administradoresRepository); // Llama al constructor de Inicio para añadir el buscador
        _iNoLogueado = new BDPrincipal(videorepository, youtuberRepository, comentariosRepository, administradoresRepository);
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
