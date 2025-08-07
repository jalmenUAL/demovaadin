package com.example.demo.views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iAdministrador;

@Route("Administrador")
@RolesAllowed("ROLE_ADMIN")
@Component

public class Administrador extends Registrado {
	public iAdministrador _iAdministrador;
	public Usuariosdenunciados _usuariosdenunciados;
	
	public Administrador(RepositorioVideo videorepository,
	                  RepositorioYoutuber youtuberRepository,
	                  RepositorioComentario comentariosRepository,
	                  RepositorioAdministrador administradoresRepository) {
		super(videorepository,
	                  youtuberRepository,
	                  comentariosRepository,
	                  administradoresRepository); // Llama al constructor de Registrado para añadir el buscador
		// Inicializa el servicio iAdministrador con la base de datos principal
		_iAdministrador = new BDPrincipal(videorepository, youtuberRepository, comentariosRepository, administradoresRepository);

		UltimosVideos();
		Usuariosdenunciados();
		
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