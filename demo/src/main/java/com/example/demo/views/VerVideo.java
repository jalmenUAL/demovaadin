package com.example.demo.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerVideo")
public class VerVideo extends VerticalLayout{
	public Videosrelacionados _videosrelacionados;
	public ListadeVideos_item _listadeVideos;
	public GaleradeVideos_item _galeradeVideos;
	public VerComentarios _verComentarios;
	public PerfilAjeno _perfilAjeno;
	HorizontalLayout video_y_relacionados = new HorizontalLayout();
	VerticalLayout frame_y_comentarios = new VerticalLayout();
	
	
	public VerVideo() {

    add(video_y_relacionados);
    video_y_relacionados.add(frame_y_comentarios);    
    video_y_relacionados.getStyle().set("width", "100%");

    // === CABECERA DEL VIDEO ===
    Image avatar = new Image("https://randomuser.me/api/portraits/men/1.jpg", "Avatar");
    avatar.setWidth("50px");
    avatar.setHeight("50px");
    avatar.getStyle().set("border-radius", "50%");

    String nombreUsuario = "Rick Astley";
    String tituloVideo = "Never Gonna Give You Up";

    VerticalLayout infoUsuario = new VerticalLayout();
    infoUsuario.setSpacing(false);
    infoUsuario.setPadding(false);
    infoUsuario.add(new Span(nombreUsuario));

    H2 titulo = new H2(tituloVideo);

    HorizontalLayout cabecera = new HorizontalLayout(avatar, infoUsuario);
    cabecera.setAlignItems(Alignment.CENTER);
    cabecera.setSpacing(true);
    cabecera.setWidthFull();

    VerticalLayout cabeceraCompleta = new VerticalLayout(titulo, cabecera);
    cabeceraCompleta.setSpacing(false);
    cabeceraCompleta.setPadding(false);

    frame_y_comentarios.add(cabeceraCompleta);

    // === VIDEO ===
    String videoId = "dQw4w9WgXcQ"; // Ejemplo
    String embedUrl = "https://www.youtube.com/embed/" + videoId;

    Div iframeContainer = new Div();
    iframeContainer.getElement().setProperty("innerHTML",
        "<iframe width='100%' height='600' " +
        "src='" + embedUrl + "' " +
        "title='YouTube video player' frameborder='0' " +
        "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
        "allowfullscreen></iframe>");
    iframeContainer.setWidth("100%");

    frame_y_comentarios.add(iframeContainer);
    frame_y_comentarios.getStyle().set("width", "350%");

    Videosrelacionados();
    VerComentarios();
    getStyle().set("width", "100%");
}
	public void Videosrelacionados() {
		_videosrelacionados = new Videosrelacionados();
		video_y_relacionados.add(_videosrelacionados);
	}

	public void VerComentarios() {
		_verComentarios = new VerComentarios();
		frame_y_comentarios.add(_verComentarios);
	}

	public void PerfilAjeno() {
		throw new UnsupportedOperationException();
	}
}
