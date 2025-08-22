package com.example.demo.views;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("PerfilAjeno")
@AnonymousAllowed
public abstract class PerfilAjeno extends Perfil {

	public PerfilAjeno() {
		

	}
	public VerVideo _verVideo;
	public VerComentarios_item _verComentarios;
	public Youtubersseguidos_item _youtubersseguidos;
 
	 
}