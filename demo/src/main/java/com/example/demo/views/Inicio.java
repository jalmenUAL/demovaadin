package com.example.demo.views;

import com.example.demo.service.iInicio;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

//import basededatos.iInicio;

@Route("Inicio")
public class Inicio extends VerticalLayout {
//	public iInicio _iInicio;
	public Buscar _buscar;
	public UltimosVideos _ultimosVideos;
	public HorizontalLayout header = new HorizontalLayout();

	
	public Inicio(iInicio inicio) {
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
        Buscar(inicio);         // Agrega componente de búsqueda
        UltimosVideos();  // Agrega sección de últimos videos
    }


	public void Buscar(iInicio inicio) {
		Buscar b = new Buscar(inicio);
		header.add(b);
	}

	public void UltimosVideos() {
		_ultimosVideos = new UltimosVideos();
		add(_ultimosVideos);
	}

}
