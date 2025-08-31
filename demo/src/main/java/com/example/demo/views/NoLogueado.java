package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.service.iNoLogueado;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("NoLogueado")
@AnonymousAllowed
public class NoLogueado extends Inicio {
    public iNoLogueado _iNoLogueado;
    public Login _login;
    public Registrar _registrar;

     /* Accede a la base de datos a través de iNoLogueado */

    public NoLogueado(iNoLogueado iNoLogueado) {
        super(iNoLogueado);
        this._iNoLogueado = iNoLogueado;

         
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

    /* Reescribe Ultimos Videos en el caso del No Logueado */
    @Override
    public void UltimosVideos() {
        List<Video> videos = _iNoLogueado.getUltimosVideos();
        _ultimosVideos = new UltimosVideos(videos);
        body.add(_ultimosVideos);
    }

    public void Login() {
        UI.getCurrent().navigate(Login.class);
    }

    public void Registrar() {
        UI.getCurrent().navigate(Registrar.class);
    }
}
