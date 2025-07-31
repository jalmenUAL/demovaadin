package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("GaleriadeVideos")
public class GaleradeVideos extends VerticalLayout {
	public Vector<GaleradeVideos_item> _item = new Vector<GaleradeVideos_item>();
	
	GaleradeVideos(){
		GaleradeVideos_item gvi = new GaleradeVideos_item();	 
		add(gvi);
    }
}