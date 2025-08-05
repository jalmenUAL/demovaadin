package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Videosrelacionados_item")

public class Videosrelacionados_item extends VerticalLayout {
    public Videosrelacionados _videosrelacionados;
    public VerVideo _verVideo;

    public Videosrelacionados_item() {
        // === Datos de ejemplo ===
        String videoId = "dQw4w9WgXcQ";
        String videoThumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";
        String tituloVideo = "Never Gonna Give You Up";
        String nombreUsuario = "Rick Astley";
        String avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg";

        // === Avatar del usuario ===
        Image avatar = new Image(avatarUrl, "Avatar");
        avatar.setWidth("30px");
        avatar.setHeight("30px");
        avatar.getStyle().set("border-radius", "50%");

        // === Nombre del usuario ===
        Span nombre = new Span(nombreUsuario);
        VerticalLayout infoUsuario = new VerticalLayout(nombre);
        infoUsuario.setPadding(false);
        infoUsuario.setSpacing(false);

        HorizontalLayout cabecera = new HorizontalLayout(avatar, infoUsuario);
        cabecera.setAlignItems(Alignment.CENTER);
        cabecera.setSpacing(true);

        // === Título del video ===
        H4 titulo = new H4(tituloVideo);
        titulo.getStyle().set("margin", "0");

        // === Imagen del video (miniatura) ===
        Image miniatura = new Image(videoThumbnailUrl, "Miniatura del video");
        miniatura.setWidth("320px");
        miniatura.setHeight("180px");
        miniatura.getStyle()
                .set("cursor", "pointer")
                .set("border-radius", "8px")
                .set("box-shadow", "0 2px 6px rgba(0,0,0,0.2)");

        miniatura.addClickListener(e -> VerVideo());

        // === Añadir componentes al layout ===
        add(titulo, cabecera, miniatura);

        // === Estilo general del layout ===
        setPadding(false);
        setSpacing(true);
        setWidth("100%");
    }

    public void VerVideo() {
        UI.getCurrent().navigate(VerVideo.class);
    }
}
