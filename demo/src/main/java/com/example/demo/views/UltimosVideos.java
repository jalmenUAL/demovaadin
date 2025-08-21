package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("UltimosVideos")
public class UltimosVideos extends GaleradeVideos {
	public Inicio _inicio;

	public UltimosVideos(List<Video> videos) {
		super(videos);
		
		tituloGaleria.setText("Últimos Videos");
		carrusel.removeAll();
		for (Video video : videos) {
			UltimosVideos_item item = new UltimosVideos_item(video);
			carrusel.add(item);
		}

	}
}