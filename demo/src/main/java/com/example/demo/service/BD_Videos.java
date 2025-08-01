package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.Video;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;

@Service

public class BD_Videos {
	public BDPrincipal _en;
	public Vector<Video> _videos = new Vector<Video>();
	private RepositorioVideo videorepository;
	private RepositorioYoutuber youtuberrepository;
	
public BD_Videos(RepositorioVideo videorepository,RepositorioYoutuber youtuberrepository) {
	this.videorepository = videorepository;
	this.youtuberrepository = youtuberrepository;
}
	
public java.util.List<Video> listar() {
    return videorepository.findAll();
}
    
public void publicar(String titulo, String url) {
	com.example.demo.domain.Youtuber y = new com.example.demo.domain.Youtuber();
	y.setLogin("jesus");
	y.setPassword("jesus");
	Video v = new Video();
	v.setTitulo(titulo);
	v.setFecha(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
	v.setUrl(url);
	v.setEs_de(y);
	youtuberrepository.save(y);
	videorepository.save(v);
}
}