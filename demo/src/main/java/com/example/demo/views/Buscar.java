package com.example.demo.views;

import com.example.demo.service.VideoService;

import com.example.demo.domain.Video;

import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.combobox.ComboBox;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Buscar")
public class Buscar extends VerticalLayout{
	public Inicio _inicio;
	public ResultadodeBusqueda _resultadodeBusqueda;

	public void ResultadodeBusqueda() {
		throw new UnsupportedOperationException();
	}
	
	Buscar(

){TextField buscar = new TextField("Buscar");	buscar.setPlaceholder("Introduzca el nombre del video que quiere buscar");
	add(buscar);
 
	}
 
}
