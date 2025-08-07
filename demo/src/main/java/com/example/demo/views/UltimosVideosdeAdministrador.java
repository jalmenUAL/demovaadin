package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeAdministrador")
public class UltimosVideosdeAdministrador extends UltimosVideos {

public UltimosVideosdeAdministrador(List<Video> videos) {

		super(videos);
		carrusel.removeAll();
		for (Video video : videos) {
			UltimosVideos_item gvi = new UltimosVideos_item(video);
			carrusel.add(gvi);
		}
		carrusel.setJustifyContentMode(JustifyContentMode.CENTER);
		carrusel.setAlignItems(Alignment.CENTER);
		carrusel.setWidth("100%");
		carrusel.setHeight("100%");
		carrusel.setSpacing(true);
		carrusel.setPadding(true);
		carrusel.setMargin(true);
		
	}
}