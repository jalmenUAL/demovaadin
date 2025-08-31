package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;


@Service

public class BD_Videos {
	public BDPrincipal _en;
	public Vector<Video> _videos = new Vector<Video>();
	private RepositorioVideo videorepository;
	private RepositorioYoutuber youtuberrepository;
    private RepositorioComentario comentariorepository;


public BD_Videos(RepositorioVideo videorepository, RepositorioYoutuber youtuberrepository,RepositorioComentario comentariorepository) {
	this.videorepository = videorepository;
	this.youtuberrepository = youtuberrepository;
    this.comentariorepository = comentariorepository;
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

        /* pone el me gusta, usuario es el propiterio de la relación le gusta, al revés no funciona */
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
    List<String> palabras = Arrays.stream(videob.getTitulo().split("\s+"))
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

/* Los OneToMany no hay que borrarlos manualmente, solo hay que poner orphanremoval = true */
/* Los ManyToMany hay que borrarlos manualmente como se hace aquí */

@Transactional
/* El transactional es imprescindible! */
public void borrarVideo(int id) {
    Video video = videorepository.findById((long) id)
        .orElseThrow(() -> new RuntimeException("Video no encontrado"));

    /* Quita los me gusta desde usuario que es el propietario  */
    for (Object y : video.getLe_gusta_a()) {
    ((Youtuber) y).getLe_gusta().removeIf(v -> ((Video) v).getId() == video.getId()); // quita el video de la lista del usuario
}
    /*Borra los comentarios */
 for (Object y : video.getTiene_comentarios()) {
    comentariorepository.delete((Comentario) y);
}
    
    
    videorepository.delete(video);
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

    /* Al no tener equals hay que utilizar el removeIf, además no funcional al revés porque usuario es el propietario */
        usuario.getLe_gusta().removeIf(v -> ((Video) v).getId() == video.getId());
     
    

    youtuberrepository.save(usuario);
    
}

 
	
 
 


}