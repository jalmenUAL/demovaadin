package com.example.demo.views;

import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeYoutuber")
public class UltimosVideosdeYoutuber extends UltimosVideos {
	
public UltimosVideosdeYoutuber() {
		
		
		
		UltimosVideos_item uvi = new UltimosVideos_item();
		carrusel.add(uvi);
		UltimosVideos_item uvi2 = new UltimosVideos_item();
		carrusel.add(uvi2);
		 
		
	}
}