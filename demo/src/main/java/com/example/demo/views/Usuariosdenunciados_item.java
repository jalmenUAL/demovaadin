package com.example.demo.views;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;

@Route("Usuariosdenunciados_item")
public class Usuariosdenunciados_item extends VerticalLayout {
    public Usuariosdenunciados _usuariosdenunciados;

    public Usuariosdenunciados_item() {
        // Datos de ejemplo
        String nombreUsuario = "Usuario Denunciado";
        String avatarUrl = "https://randomuser.me/api/portraits/men/2.jpg";

        Avatar avatar = new Avatar(nombreUsuario, avatarUrl);
        Span nombreSpan = new Span(nombreUsuario);
        nombreSpan.getStyle().set("font-weight", "bold").set("font-size", "1.1em");

        HorizontalLayout infoLayout = new HorizontalLayout(avatar, nombreSpan);
        infoLayout.setAlignItems(Alignment.CENTER);

        add(infoLayout);

        // Hace que todo el item sea clickable y navegue al perfil de administrador
        this.getStyle().set("cursor", "pointer");
        this.addClickListener((ComponentEventListener<ClickEvent<VerticalLayout>>) event ->
            UI.getCurrent().navigate("PerfilAjenodeAdministrador")
        );
    }
}