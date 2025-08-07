package com.example.demo.service;

import java.util.Vector;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;
import com.example.demo.domain.RepositorioVideo;

@Service

public class BD_Videos {
	public BDPrincipal _en;
	public Vector<Video> _videos = new Vector<Video>();
	private RepositorioVideo videorepository;
	
	
public BD_Videos(RepositorioVideo videorepository) {
	this.videorepository = videorepository;
	
}


public java.util.List<Video> buscar(String texto) {
	// TODO Auto-generated method stub
	java.util.List<Video>  videos = videorepository.findAll();
	return videos;
}


public void publicarVideo(String value, String value2) {
	// TODO Auto-generated method stub
	Video video = new Video();
	video.setTitulo(value);
	video.setUrl(value2);
	videorepository.save(video);
	
}


public java.util.List<Video> getUltimosVideos() {
	// TODO Auto-generated method stub
	java.util.List<Video> UltimosVideos = videorepository.findAll();
	if (UltimosVideos.size() > 10) {
		UltimosVideos = UltimosVideos.subList(0, 10);
	}
	return UltimosVideos;
}

 
	
 
 


}