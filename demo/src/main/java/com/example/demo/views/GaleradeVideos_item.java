package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout.Alignment;

@Route("GaleriadeVideos_item")
public class GaleradeVideos_item  extends VerticalLayout{
	public GaleradeVideos _galeradeVideos;
	public VerVideo _verVideo;

	public void VerVideo() {
		UI.getCurrent().navigate(VerVideo.class);
	}
	
	public GaleradeVideos_item(){
		// Datos de ejemplo
        String videoId = "dQw4w9WgXcQ"; // Ejemplo
        String embedUrl = "https://www.youtube.com/embed/" + videoId;
        String tituloVideo = "Título de ejemplo del video";
        String propietarioNombre = "Propietario Ejemplo";
        String propietarioFotoUrl = "https://randomuser.me/api/portraits/men/1.jpg"; // URL de ejemplo

        // Título del video
        Span tituloSpan = new Span(tituloVideo);
        tituloSpan.getStyle().set("font-weight", "bold").set("font-size", "1.2em");

        // Avatar del propietario
        Avatar propietarioAvatar = new Avatar(propietarioNombre, propietarioFotoUrl);

        // Layout horizontal para avatar y título
        HorizontalLayout infoLayout = new HorizontalLayout(propietarioAvatar, tituloSpan);
        infoLayout.setAlignItems(Alignment.CENTER);
        add(infoLayout);

        // Crear el iframe manualmente
        Div iframeContainer = new Div();
        iframeContainer.getElement().setProperty("innerHTML",
            "<iframe width='560' height='315' " +
            "src='" + embedUrl + "' " +
            "title='YouTube video player' frameborder='0' " +
            "allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
            "allowfullscreen></iframe>");
        add(iframeContainer);
		
		Button vervideo = new Button("Ver Video");
		vervideo.addClickListener(e -> {VerVideo();
		});
        
		add(vervideo);
        
	}
}