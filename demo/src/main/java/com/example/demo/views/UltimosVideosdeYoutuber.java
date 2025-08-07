package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeYoutuber")
public class UltimosVideosdeYoutuber extends UltimosVideos {

public UltimosVideosdeYoutuber(List<Video> videos) {
	super(videos);
	carrusel.removeAll();
	for (Video video : videos) {
		UltimosVideos_item gvi = new UltimosVideosdeYoutuber_item(video);
		carrusel.add(gvi);			
		 
		
	}

}
	 
}