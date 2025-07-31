package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("GaleriadeVideos_item")
public class GaleradeVideos_item  extends VerticalLayout{
	public GaleradeVideos _galeradeVideos;
	public VerVideo _verVideo;

	public void VerVideo() {
		UI.getCurrent().navigate(PublicarVideo.class);
	}
	
	GaleradeVideos_item(){
		Button vervideo = new Button("Ver Video");
		vervideo.addClickListener(e -> {VerVideo();
		});
        // Cambia la URL por el ID del video que quieres mostrar
        String videoId = "dQw4w9WgXcQ"; // Ejemplo
        String embedUrl = "https://www.youtube.com/embed/" + videoId;

        // Crear el iframe manualmente
        Div iframeContainer = new Div();
        iframeContainer.getElement().setProperty("innerHTML",
            "<iframe width='560' height='315' " +
            "src='" + embedUrl + "' " +
            "title='YouTube video player' frameborder='0' " +
            "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
            "allowfullscreen></iframe>");

        add(vervideo, iframeContainer);
	}
}