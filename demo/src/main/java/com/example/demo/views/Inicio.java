package com.example.demo.views;

import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

//import basededatos.iInicio;

@Route("Inicio")
public class Inicio extends VerticalLayout {
//	public iInicio _iInicio;
	public Buscar _buscar;
	public UltimosVideos _ultimosVideos;

	
	public Inicio() {
	    H1 heading1 = new H1("Youtube");
	    heading1.getStyle()
	        .set("background-color", "red")
	        .set("color", "white")
	        .set("padding", "0.5em 1em")
	        .set("border-radius", "8px")
	        .set("width", "fit-content");
	    add(heading1);
	    Buscar();
	    UltimosVideos();
	}

	public void Buscar() {
		Buscar b = new Buscar();		
		add(b);
	}

	public void UltimosVideos() {
		_ultimosVideos = new UltimosVideos();
		add(_ultimosVideos);
	}

}
