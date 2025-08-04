package com.example.demo.views;

import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iAdministrador;

@Route("Administrador")
@RolesAllowed("ADMIN")
public class Administrador extends Registrado {
	//public iAdministrador _iAdministrador;
	public Usuariosdenunciados _usuariosdenunciados;
	
	public Administrador() {
		super();
		UltimosVideos();
		Usuariosdenunciados();
		
	}

	public void Usuariosdenunciados() {
		_usuariosdenunciados = new Usuariosdenunciados();
		add(_usuariosdenunciados);
	}
	
	 
	public void UltimosVideos() {
		_ultimosVideos = new UltimosVideosdeAdministrador();
		add(_ultimosVideos);
	}
}