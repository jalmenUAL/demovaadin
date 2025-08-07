package com.example.demo.views;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("Videospublicados")

public class Videospublicados extends ListadeVideos {
	public Videospublicados(Set<Video> videos) {
		super(videos);
		//TODO Auto-generated constructor stub
	}

	public Perfil _perfil;
}