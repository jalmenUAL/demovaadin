package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
 import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@Route("GaleriadeVideos_item")
public class GaleradeVideos_item extends VerticalLayout {
    public GaleradeVideos _galeradeVideos;
    public VerVideo _verVideo;
     // Datos de ejemplo
      public String videoId = "dQw4w9WgXcQ"; // ID del video
        public String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";
        public String tituloVideo = "Título de ejemplo del video";
        public String propietarioNombre = "Propietario Ejemplo";
        public String propietarioFotoUrl = "https://randomuser.me/api/portraits/men/1.jpg";

    public void VerVideo() {
        UI.getCurrent().navigate(VerVideo.class);
    }

    public GaleradeVideos_item() {
       

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

        // Imagen estática del video (thumbnail)
        Image thumbnail = new Image(thumbnailUrl, "Thumbnail del video");
        thumbnail.setWidth("100%");
        thumbnail.getStyle().set("border-radius", "8px").set("cursor", "pointer");

        // Al hacer clic en la imagen, navegar al video
        thumbnail.addClickListener(e -> VerVideo());

        add(thumbnail);

        // Botón para ver el video
        Button verVideoBtn = new Button("Ver Video");
        verVideoBtn.addClickListener(e -> VerVideo());
        verVideoBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(verVideoBtn);
    }
    public String getVideoId() {
        return videoId;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public String getTituloVideo() {
        return tituloVideo;
    }

    public String getPropietarioNombre() {
        return propietarioNombre;
    }

    public String getPropietarioFotoUrl() {
        return propietarioFotoUrl;
    }
    public String setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this.thumbnailUrl;
    }
    public String setTituloVideo(String tituloVideo) {
        this.tituloVideo = tituloVideo;
        return this.tituloVideo;
    }
    public String setPropietarioNombre(String propietarioNombre) {
        this.propietarioNombre = propietarioNombre;
        return this.propietarioNombre;
    }
    public String setPropietarioFotoUrl(String propietarioFotoUrl) {
        this.propietarioFotoUrl = propietarioFotoUrl;
        return this.propietarioFotoUrl;
    }
}