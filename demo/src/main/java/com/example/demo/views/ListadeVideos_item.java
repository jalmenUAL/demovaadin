package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("ListadeVideos_item")
public class ListadeVideos_item extends VerticalLayout {
    public ListadeVideos _listadeVideos;
    public VerVideo _verVideo;

    public void VerVideo() {
        UI.getCurrent().navigate(VerVideo.class);
    }

    public ListadeVideos_item() {
        // Datos de ejemplo
        String videoId = "dQw4w9WgXcQ";
        String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";
        String tituloVideo = "Título de ejemplo del video";
        String propietarioNombre = "Propietario Ejemplo";
        String propietarioFotoUrl = "https://randomuser.me/api/portraits/men/1.jpg";
        int numMeGustas = 123;
        int numComentarios = 45;

        // Título del video
        Span tituloSpan = new Span(tituloVideo);
        tituloSpan.getStyle().set("font-weight", "bold").set("font-size", "1.2em");

        // Avatar del propietario
        Avatar propietarioAvatar = new Avatar(propietarioNombre, propietarioFotoUrl);

        // Layout horizontal para avatar y título
        HorizontalLayout infoLayout = new HorizontalLayout(propietarioAvatar, tituloSpan);
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.setSpacing(true);
        add(infoLayout);

        // Estadísticas de me gustas y comentarios
        Span meGustasSpan = new Span("👍 " + numMeGustas);
        Span comentariosSpan = new Span("💬 " + numComentarios);
        HorizontalLayout statsLayout = new HorizontalLayout(meGustasSpan, comentariosSpan);
        statsLayout.setSpacing(true);
        add(statsLayout);

        // Imagen del thumbnail en vez de iframe
        Image thumbnail = new Image(thumbnailUrl, "Miniatura del video");
        thumbnail.setWidth("100%");
        thumbnail.getStyle().set("border-radius", "8px").set("cursor", "pointer");
        thumbnail.addClickListener(e -> VerVideo());

        add(thumbnail);

        // Botón para ver el video
        Button verVideoBtn = new Button("Ver Video");
        verVideoBtn.addClickListener(e -> VerVideo());
        verVideoBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(verVideoBtn);
    }
}
