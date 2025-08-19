package com.example.demo.views;

import com.example.demo.domain.Youtuber;
import com.example.demo.service.iInicio;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.router.Route;

@Route("PerfilAjeno")
public class PerfilAjeno extends Perfil {

	public PerfilAjeno(iInicio iInicio) {
		super(iInicio);

	}
	public VerVideo _verVideo;
	public VerComentarios_item _verComentarios;
	public Youtubersseguidos_item _youtubersseguidos;
	 
}