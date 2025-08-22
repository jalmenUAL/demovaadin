package com.example.demo.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Usuariosdenunciados_item")
public class Usuariosdenunciados_item extends VerticalLayout {
    public Usuariosdenunciados _usuariosdenunciados;

    public Usuariosdenunciados_item(com.example.demo.domain.Youtuber youtuber) {
        // Datos de ejemplo
        String nombreUsuario = youtuber.getLogin();
        String avatarUrl = youtuber.getFotoPerfil();

        Image avatar = new Image(avatarUrl, nombreUsuario);
        avatar.setWidth("50px");
        avatar.setHeight("50px");
        avatar.getStyle().set("border-radius", "50%");
        avatar.addClickListener(event -> {
            // Navegar al perfil del usuario al hacer clic en el avatar
            getUI().ifPresent(ui -> ui.navigate("PerfilAjenodeAdministrador/" + youtuber.getLogin()));
        });

        Span nombreSpan = new Span(nombreUsuario);
        nombreSpan.getStyle().set("font-weight", "bold").set("font-size", "1.1em");

        HorizontalLayout infoLayout = new HorizontalLayout(avatar, nombreSpan);
        infoLayout.setAlignItems(Alignment.CENTER);

        add(infoLayout);


    }
}