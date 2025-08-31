package com.example.demo.views;

import java.util.Set;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("Videosgustados")

public class Videosgustados extends ListadeVideos {
	public Videosgustados(Set<Video> videos) {
		super(videos);
 	}

	public Perfil _perfil;
}