package com.example.demo.service;

import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;

@Service

public class BD_Videos {
	public BDPrincipal _en;
	public Vector<Video> _videos = new Vector<Video>();
	private RepositorioVideo videorepository;
	private RepositorioYoutuber youtuberrepository;


public BD_Videos(RepositorioVideo videorepository, RepositorioYoutuber youtuberrepository) {
	this.videorepository = videorepository;
	this.youtuberrepository = youtuberrepository;
}


public java.util.List<Video> buscar(String texto) {
	 
	java.util.List<Video>  videos = videorepository.findAll();
	return videos;
}


public void publicarVideo(String value, String value2) {
	 
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
	com.example.demo.domain.Youtuber yt = youtuberrepository.findById(username)
		.orElseThrow(() -> new RuntimeException("Youtuber no encontrado"));
	Video video = new Video();
	video.setTitulo(value);
	video.setUrl(value2);
	video.setEs_de(yt);
	videorepository.save(video);
	
}


public java.util.List<Video> getUltimosVideos() {
	 
	java.util.List<Video> UltimosVideos = videorepository.findAll();
	if (UltimosVideos.size() > 10) {
		UltimosVideos = UltimosVideos.subList(0, 10);
	}
	return UltimosVideos;
}


public Video findVideoById(Long parameter) {
	return videorepository.findById(parameter)
			.orElseThrow(() -> new RuntimeException("Video no encontrado"));
}

 
	
 
 


}