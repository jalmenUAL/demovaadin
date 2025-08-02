package com.example.demo.views;

import com.example.demo.service.iYoutuber;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iYoutuber;

@Route("Youtuber")
@RolesAllowed("USER")
public class Youtuber extends Registrado {
    public iYoutuber _iYoutuber;
	public PerfilPropio _perfilPropio;

	public void PerfilPropio() {
		throw new UnsupportedOperationException();
	}
	@Override
	public void UltimosVideos() {
		UltimosVideosdeYoutuber uv = new UltimosVideosdeYoutuber();
		add(uv);
	}
	
	public Youtuber() {
		super();
		UltimosVideos();
	}
}