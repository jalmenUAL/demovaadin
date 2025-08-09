package com.example.demo.views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.iInicio;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.UIScope;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iInicio;

@Route("Inicio")
@Component
@UIScope  // importante

public class Inicio extends VerticalLayout {
	public iInicio _iInicio;
	public Buscar _buscar;
	public UltimosVideos _ultimosVideos;
	public HorizontalLayout header = new HorizontalLayout();
	

	 

	// Constructor que recibe el servicio iInicio


	public Inicio(RepositorioVideo videorepository,
		RepositorioYoutuber youtuberRepository,
		RepositorioComentario comentariosRepository,
		RepositorioAdministrador administradoresRepository) {

		//_iInicio = new BDPrincipal(videorepository, youtuberRepository, comentariosRepository, administradoresRepository);

        // Estilos generales del layout
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setAlignItems(Alignment.CENTER);

        // Título principal
        H1 heading = new H1("YouTube");
        heading.getStyle()
            .set("background-color", "#FF0000")   // Rojo YouTube
            .set("color", "white")
            .set("padding", "0.5em 1.5em")
            .set("border-radius", "10px")
            .set("font-size", "2.5em")
            .set("box-shadow", "0 4px 8px rgba(0,0,0,0.2)");

        // Header layout con el título centrado
        header.setWidthFull();
        header.setJustifyContentMode(JustifyContentMode.CENTER);
        header.add(heading);

        add(header);

        // Métodos adicionales
        Buscar(_iInicio);         // Agrega componente de búsqueda
        //UltimosVideos();  // Agrega sección de últimos videos
    }


	public void Buscar(iInicio inicio) {
		Buscar b = new Buscar(inicio);
		header.add(b);
	}

	public void UltimosVideos() {
		List<Video> videos = _iInicio.getUltimosVideos();
		if (!(videos == null || videos.isEmpty())) {
			_ultimosVideos = new UltimosVideos(videos);
			add(_ultimosVideos);
		}
	}

}
