package com.example.demo.views;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("ListadeVideos_item")
public class ListadeVideos_item extends VerticalLayout {
    public ListadeVideos _listadeVideos;
    public VerVideo _verVideo;

    public void VerVideo() {
        // Aquí puedes navegar a la vista de video real
        // UI.getCurrent().navigate(VerVideo.class);
        throw new UnsupportedOperationException();
    }

    public ListadeVideos_item() {
        // Datos de ejemplo
        String videoId = "dQw4w9WgXcQ";
        String embedUrl = "https://www.youtube.com/embed/" + videoId;
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
        infoLayout.setAlignItems(HorizontalLayout.Alignment.CENTER);
        add(infoLayout);

        // Span para me gustas y comentarios
        Span meGustasSpan = new Span("👍 " + numMeGustas);
        Span comentariosSpan = new Span("💬 " + numComentarios);
        HorizontalLayout statsLayout = new HorizontalLayout(meGustasSpan, comentariosSpan);
        add(statsLayout);

        // Iframe del video
        Div iframeContainer = new Div();
        iframeContainer.getElement().setProperty("innerHTML",
            "<iframe width='560' height='315' " +
            "src='" + embedUrl + "' " +
            "title='YouTube video player' frameborder='0' " +
            "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
            "allowfullscreen></iframe>");
        add(iframeContainer);

        // Botón para ver el video
        Button vervideo = new Button("Ver Video");
        vervideo.addClickListener(e -> VerVideo());
        add(vervideo);
    }
}