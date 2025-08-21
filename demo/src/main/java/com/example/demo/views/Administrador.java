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
		super(iAdministrador);
		// Es necesario para que _iAdministrador no sea nulo
		_iAdministrador = iAdministrador;

	}

	public void Usuariosdenunciados() {
		//Es necesario hacerlo después del onAttach para asegurar que _iAdministrador sea no nulo.
	}

	public void UltimosVideos() {
		//Es necesario hacerlo después del onAttach para asegurar que _iAdministrador sea no nulo.
	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);

		List<Video> videos = _iAdministrador.getUltimosVideos();
		_ultimosVideos = new UltimosVideosdeAdministrador(videos);
		body.add(_ultimosVideos);

		List<com.example.demo.domain.Youtuber> denunciados = _iAdministrador.buscarDenunciados();
		_usuariosdenunciados = new Usuariosdenunciados(denunciados);
		body.add(_usuariosdenunciados);

	}
}