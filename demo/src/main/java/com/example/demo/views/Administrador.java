package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@Route("Administrador")
@RolesAllowed("ROLE_ADMINISTRADOR")

public class Administrador extends Registrado {
	public iAdministrador _iAdministrador;
	public Usuariosdenunciados _usuariosdenunciados;

	public Administrador(iAdministrador iAdministrador) {
		 
		 
		_iAdministrador = iAdministrador;

	}

	public void Usuariosdenunciados() {
		 
		List<com.example.demo.domain.Youtuber> denunciados = _iAdministrador.buscarDenunciados();
		_usuariosdenunciados = new Usuariosdenunciados(denunciados);
		body.add(_usuariosdenunciados);
	}



	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);

		/* Es necesario hacer aquí la llamada para que _usuariosdenunciados no sea nulo */
		Usuariosdenunciados();

		 

		

	}

	@Override
	public void UltimosVideos() {
		List<Video> ultimosVideos = _iAdministrador.getAllVideos();
		_ultimosVideos = new UltimosVideos(ultimosVideos);
		body.add(_ultimosVideos);
	}
}