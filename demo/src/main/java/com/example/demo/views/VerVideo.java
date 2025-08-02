package com.example.demo.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import com.vaadin.flow.component.html.Div;
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
		
		// Cambia la URL por el ID del video que quieres mostrar
        String videoId = "dQw4w9WgXcQ"; // Ejemplo
        String embedUrl = "https://www.youtube.com/embed/" + videoId;

        // Crear el iframe manualmente
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
