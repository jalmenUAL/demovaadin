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
		
	}

	public void Usuariosdenunciados() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void UltimosVideos() {
		UltimosVideosdeAdministrador uv = new UltimosVideosdeAdministrador();
		add(uv);
	}
}