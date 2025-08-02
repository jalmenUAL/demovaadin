package com.example.demo.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Videosrelacionados_item")

public class Videosrelacionados_item extends VerticalLayout{
	public Videosrelacionados _videosrelacionados;
	public VerVideo _verVideo;
	
	public Videosrelacionados_item(){
		
		// Cambia la URL por el ID del video que quieres mostrar
        String videoId = "dQw4w9WgXcQ"; // Ejemplo
        String embedUrl = "https://www.youtube.com/embed/" + videoId;

        // Crear el iframe manualmente
        Div iframeContainer = new Div();
        iframeContainer.getElement().setProperty("innerHTML",
            "<iframe width='320' height='160' " +
            "src='" + embedUrl + "' " +
            "title='YouTube video player' frameborder='0' " +
            "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
            "allowfullscreen></iframe>");
         
        add(iframeContainer);
		
	}

	public void VerVideo() {
		throw new UnsupportedOperationException();
	}
}