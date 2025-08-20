package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.service.BD_Administradores;
import com.example.demo.service.BD_Comentarios;
import com.example.demo.service.BD_Videos;
import com.example.demo.service.BD_Youtubers;
import com.example.demo.service.iInicio;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

//import basededatos.iInicio;

@Route("Inicio")
@AnonymousAllowed


public class Inicio extends VerticalLayout {
	public iInicio _iInicio;
	public Buscar _buscar;
	public UltimosVideos _ultimosVideos;
	public HorizontalLayout header = new HorizontalLayout();
	

	 

	// Constructor que recibe el servicio iInicio


	public Inicio(iInicio iInicio) { //BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers, BD_Administradores administradores) {
        this._iInicio = iInicio;
		//_iInicio = new BDPrincipal(videos, comentarios, youtubers, administradores);

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
        Buscar();         // Agrega componente de búsqueda
        UltimosVideos();  // Agrega sección de últimos videos
    }


	 

    public void Buscar() {
		Buscar b = new Buscar(_iInicio);
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
