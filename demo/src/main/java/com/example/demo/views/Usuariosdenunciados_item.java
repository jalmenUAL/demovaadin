package com.example.demo.views;

import com.vaadin.flow.component.avatar.Avatar;
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

        Avatar avatar = new Avatar(nombreUsuario, avatarUrl);
        Span nombreSpan = new Span(nombreUsuario);
        nombreSpan.getStyle().set("font-weight", "bold").set("font-size", "1.1em");

        HorizontalLayout infoLayout = new HorizontalLayout(avatar, nombreSpan);
        infoLayout.setAlignItems(Alignment.CENTER);

        add(infoLayout);
    }
}