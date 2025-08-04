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
	
	public Youtuber() {
		super();
		UltimosVideos();
		PerfilPropio();
	}

	public void PerfilPropio() {
		_perfilPropio = new PerfilPropio();
		add(_perfilPropio);
	}
	 
	public void UltimosVideos() {
		_ultimosVideos = new UltimosVideosdeYoutuber();
		add(_ultimosVideos);
	}
	
	
}