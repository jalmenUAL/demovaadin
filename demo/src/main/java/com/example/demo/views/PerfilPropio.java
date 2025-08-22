package com.example.demo.views;

import com.example.demo.domain.Youtuber;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;


import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@Route("PerfilPropio")
@RolesAllowed("ROLE_YOUTUBER")
public class PerfilPropio extends Perfil {

    public com.example.demo.domain.Youtuber _youtuber;
    public PublicarVideo _publicarVideo;
    public Configuracion _configuracion;
    public iYoutuber _iYoutuber;

    public PerfilPropio(iYoutuber iYoutuber) {

        this._iYoutuber = iYoutuber;
        // === Crear botones ===
        Button publicarButton = new Button("📤 Publicar video", event -> PublicarVideo());
        Button configButton = new Button("⚙️ Configuración", event -> Configuracion());

        // Estilizar botones (opcional)
        publicarButton.getStyle()
            .set("background-color", "#0d6efd")
            .set("color", "white")
            .set("border-radius", "8px")
            .set("font-weight", "bold");

        configButton.getStyle()
            .set("background-color", "#6c757d")
            .set("color", "white")
            .set("border-radius", "8px")
            .set("font-weight", "bold");

        // === Layout de botones alineado a la derecha ===
        HorizontalLayout botonesHeader = new HorizontalLayout(publicarButton, configButton);
        botonesHeader.setWidthFull();
        botonesHeader.setJustifyContentMode(JustifyContentMode.END);
        botonesHeader.setPadding(true);

        // Agregar los botones al inicio de la vista
        topLayout.add(botonesHeader);
    }

    public void PublicarVideo() {
       UI.getCurrent().navigate(PublicarVideo.class);
    }

    public void Configuracion() {
        UI.getCurrent().navigate(Configuracion.class);
    }

    @Override
    public Youtuber getUsuario(String username) {
       return _iYoutuber.findYoutuberById(username);
    }
}