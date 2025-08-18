package com.example.demo.views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.BD_Administradores;
import com.example.demo.service.BD_Comentarios;
import com.example.demo.service.BD_Videos;
import com.example.demo.service.BD_Youtubers;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iAdministrador;

@Route("Administrador")
@RolesAllowed("ROLE_ADMINISTRADOR")
 

public class Administrador extends Registrado {
	public iAdministrador _iAdministrador;
	public Usuariosdenunciados _usuariosdenunciados;
	
	public Administrador(BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers, BD_Administradores administradores) {
		super(videos, comentarios, youtubers, administradores);
		//_iAdministrador = new BDPrincipal(videos, comentarios, youtubers, administradores);

		//UltimosVideos();
		//Usuariosdenunciados();
		
	}

	public void Usuariosdenunciados() {
		List<com.example.demo.domain.Youtuber> denunciados = _iAdministrador.buscarDenunciados();
		_usuariosdenunciados = new Usuariosdenunciados(denunciados);
		add(_usuariosdenunciados);
	}
	
	 
	public void UltimosVideos() {
		//List<Video> videos = _iAdministrador.getUltimosVideos();
		//_ultimosVideos = new UltimosVideosdeAdministrador(videos);
		//add(_ultimosVideos);
	}
}