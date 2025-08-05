package com.example.demo.views;

import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeAdministrador")
public class UltimosVideosdeAdministrador extends UltimosVideos {
	
public UltimosVideosdeAdministrador() {
		
		
		carrusel.removeAll();
		UltimosVideos_item uvi = new UltimosVideosdeAdministrador_item();
		carrusel.add(uvi);
		UltimosVideos_item uvi2 = new UltimosVideosdeAdministrador_item();
		carrusel.add(uvi2);
		UltimosVideos_item uvi3 = new UltimosVideosdeAdministrador_item();
		carrusel.add(uvi3);
		UltimosVideos_item uvi4 = new UltimosVideosdeAdministrador_item();
		carrusel.add(uvi4);
		UltimosVideos_item uvi5 = new UltimosVideosdeAdministrador_item();
		carrusel.add(uvi5);
		
	}
}