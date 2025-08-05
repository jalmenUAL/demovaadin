package com.example.demo.views;

import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeYoutuber")
public class UltimosVideosdeYoutuber extends UltimosVideos {
	
public UltimosVideosdeYoutuber() {
		
		
		carrusel.removeAll();
		UltimosVideos_item uvi = new UltimosVideosdeYoutuber_item();
		carrusel.add(uvi);
		UltimosVideos_item uvi2 = new UltimosVideosdeYoutuber_item();
		carrusel.add(uvi2);
		 
		
	}
}