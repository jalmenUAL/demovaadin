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
		// TODO Auto-generated constructor stub

	}
}