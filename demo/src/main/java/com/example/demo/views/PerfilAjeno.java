package com.example.demo.views;

import com.example.demo.domain.Youtuber;
import com.vaadin.flow.router.Route;

@Route("PerfilAjeno")
public class PerfilAjeno extends Perfil {
	
	public PerfilAjeno(Youtuber youtuber) {
		super(youtuber);

		//TODO Auto-generated constructor stub
	}
	public VerVideo _verVideo;
	public VerComentarios_item _verComentarios;
	public Youtubersseguidos_item _youtubersseguidos;
	 
}