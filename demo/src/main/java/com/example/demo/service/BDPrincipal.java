package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;

@Service
public class BDPrincipal implements iNoLogueado, iYoutuber, iAdministrador, iRegistrado, iInicio {
	public BD_Videos _videos;
	public BD_Comentarios _comentarios;
	public BD_Youtubers _youtubers;
	public BD_Administradores _administradores;
	
	 
	
public BDPrincipal(RepositorioVideo videorepository,RepositorioYoutuber youtuberrepository) {
	 
	_videos = new BD_Videos(videorepository,youtuberrepository);
}
	
	public void publicar(String titulo, String url) {
		_videos.publicar(titulo, url);
	}
	
	public java.util.List<Video> listar(){
		return _videos.listar();
	}
}