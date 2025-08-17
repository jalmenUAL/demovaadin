package com.example.demo.views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.BD_Administradores;
import com.example.demo.service.BD_Comentarios;
import com.example.demo.service.BD_Videos;
import com.example.demo.service.BD_Youtubers;
import com.example.demo.service.iInicio;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.UIScope;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

//import basededatos.iInicio;

@Route("Inicio")



public class Inicio extends VerticalLayout {
	public iInicio _iInicio;
	public Buscar _buscar;
	public UltimosVideos _ultimosVideos;
	public HorizontalLayout header = new HorizontalLayout();
	

	 

	// Constructor que recibe el servicio iInicio


	public Inicio(BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers, BD_Administradores administradores) {

		_iInicio = new BDPrincipal(videos, comentarios, youtubers, administradores);

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


	public Inicio(BD_Youtubers youtubers, BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers2,
            BD_Administradores administradores) {
        //TODO Auto-generated constructor stub
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
