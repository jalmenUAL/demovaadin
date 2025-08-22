package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;
import com.example.demo.views.Videosgustados;

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

	List<Video> busqueda = videorepository.findAll();
        return busqueda.stream()
                .filter(video -> video.getTitulo().contains(texto))
                .toList();
}


public void publicarVideo(String value, String value2) {
	 
	Youtuber yt = (Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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


public void likeVideo(int id) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
		throw new RuntimeException("Usuario no autenticado");
	}

	Youtuber usuario = (Youtuber) auth.getPrincipal();
	Video video = videorepository.findById((long) id)
			.orElseThrow(() -> new RuntimeException("Video no encontrado"));

	if (video.getLe_gusta_a().contains(usuario)) {
		// Si ya le gusta, quitar el like
		video.getLe_gusta_a().remove(usuario);
	} else {
		// Si no le gusta, añadir el like
		video.getLe_gusta_a().add(usuario);
	}

	videorepository.save(video);
}

 
	
 
 


}