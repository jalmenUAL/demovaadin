package com.example.demo.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Videosrelacionados_item")

public class Videosrelacionados_item extends VerticalLayout{
	public Videosrelacionados _videosrelacionados;
	public VerVideo _verVideo;
	
	    public Videosrelacionados_item() {
        // === Datos de ejemplo ===
        String videoId = "dQw4w9WgXcQ";
        String embedUrl = "https://www.youtube.com/embed/" + videoId;
        String tituloVideo = "Never Gonna Give You Up";
        String nombreUsuario = "Rick Astley";
        String avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg"; // Cambia esta URL

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

        // === Video (iframe embebido) ===
        Div iframeContainer = new Div();
        iframeContainer.getElement().setProperty("innerHTML",
            "<iframe width='320' height='160' " +
            "src='" + embedUrl + "' " +
            "title='YouTube video player' frameborder='0' " +
            "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
            "allowfullscreen></iframe>");

        // === Añadir todo en orden ===
        add(titulo, cabecera, iframeContainer);

        // Opcional: Estilo del contenedor
        setPadding(false);
        setSpacing(true);
        setWidth("100%");
    }

	public void VerVideo() {
		throw new UnsupportedOperationException();
	}
}