package com.example.demo.views;

import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeAdministrador")
public class UltimosVideosdeAdministrador extends UltimosVideos {
	
public UltimosVideosdeAdministrador() {
		
		
		
		UltimosVideos_item uvi = new UltimosVideos_item();
		carrusel.add(uvi);
		UltimosVideos_item uvi2 = new UltimosVideos_item();
		carrusel.add(uvi2);
		UltimosVideos_item uvi3 = new UltimosVideos_item();
		carrusel.add(uvi3);
		UltimosVideos_item uvi4 = new UltimosVideos_item();
		carrusel.add(uvi4);
		UltimosVideos_item uvi5 = new UltimosVideos_item();
		carrusel.add(uvi5);
		
	}
}