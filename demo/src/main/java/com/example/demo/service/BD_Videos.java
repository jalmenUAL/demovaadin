package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;
import com.vaadin.flow.component.notification.Notification;


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
    if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
        throw new RuntimeException("Usuario no autenticado");
    }

    String login = auth.getName();
    Youtuber usuario = youtuberrepository.findById(login)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    Video video = videorepository.findById((long) id)
        .orElseThrow(() -> new RuntimeException("Video no encontrado"));

    
        usuario.getLe_gusta().add(video);
    


    youtuberrepository.save(usuario); // 💡 guardamos el dueño, no el inverso
}


public List<Video> getAllVideos() {
    return videorepository.findAll();
}


public List<Video> getVideosRelacionados(int id) {
    Video videob = videorepository.findById((long) id)
        .orElseThrow(() -> new RuntimeException("Video no encontrado"));

    // Dividir en palabras y pasarlas a minúsculas
    List<String> palabras = Arrays.stream(videob.getTitulo().split("\\s+"))
                                  .map(String::toLowerCase)
                                  .toList();

    List<Video> busqueda = videorepository.findAll();

    return busqueda.stream()
            // Excluir el propio video
            .filter(video -> !(video.getId()==videob.getId()))
            // Comparar títulos ignorando mayúsculas
            .filter(video -> {
                String titulo = video.getTitulo().toLowerCase();
                return palabras.stream().anyMatch(titulo::contains);
            })
            .toList();
}


public void borrarVideo(int id) {
	 Video videob = videorepository.findById((long) id)
        .orElseThrow(() -> new RuntimeException("Video no encontrado"));
        
	videorepository.delete(videob);
}


public void dislikeVideo(int id) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
        throw new RuntimeException("Usuario no autenticado");
    }

    String login = auth.getName();
    Youtuber usuario = youtuberrepository.findById(login)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    Video video = videorepository.findById((long) id)
        .orElseThrow(() -> new RuntimeException("Video no encontrado"));

    
        usuario.getLe_gusta()
    .removeIf(v -> ((Video) v).getId() == video.getId());
        
    

    youtuberrepository.save(usuario);
    
}

 
	
 
 


}