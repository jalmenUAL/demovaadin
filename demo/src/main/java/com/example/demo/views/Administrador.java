package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iAdministrador;

@Route("Administrador")
@RolesAllowed("ADMIN")
public class Administrador extends Registrado {
	public iAdministrador _iAdministrador;
	public Usuariosdenunciados _usuariosdenunciados;
	
	public Administrador(iAdministrador administrador) {
		super(administrador);
		UltimosVideos();
		Usuariosdenunciados();
		
	}

	public void Usuariosdenunciados() {
		List<com.example.demo.domain.Youtuber> denunciados = _iAdministrador.buscarDenunciados();
		_usuariosdenunciados = new Usuariosdenunciados(denunciados);
		add(_usuariosdenunciados);
	}
	
	 
	public void UltimosVideos() {
		List<Video> videos = _iAdministrador.getUltimosVideos();
		_ultimosVideos = new UltimosVideosdeAdministrador(videos);
		add(_ultimosVideos);
	}
}