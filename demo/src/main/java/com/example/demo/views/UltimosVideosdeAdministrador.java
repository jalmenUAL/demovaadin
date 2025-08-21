package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeAdministrador")
public class UltimosVideosdeAdministrador extends UltimosVideos {

public UltimosVideosdeAdministrador(List<Video> videos) {

		super(videos);
		
		tituloGaleria.setText("Todos los videos");
		carrusel.removeAll();
		for (Video video : videos) {
			UltimosVideos_item gvi = new UltimosVideosdeAdministrador_item(video);
			carrusel.add(gvi);
		}
		
		
	}
}