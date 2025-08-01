package com.example.demo.views;

import com.vaadin.flow.router.Route;

@Route("ResultadodeBusqueda")

public class ResultadodeBusqueda extends GaleradeVideos {
	public Buscar _buscar;
	
	public ResultadodeBusqueda(){
	ResultadodeBusqueda_item gvi = new ResultadodeBusqueda_item();	 
	add(gvi);
	}
}