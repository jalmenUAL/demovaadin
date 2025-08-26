package com.example.demo.service;

import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

@Service

public class BD_Comentarios {
	public BD_Comentarios(RepositorioComentario comentariosRepository,RepositorioVideo videosRepository) {
        repository = comentariosRepository;
        repositoryvideo = videosRepository;
         
    }

    
    public BDPrincipal _en;
	public Vector<Comentario> _comentarios = new Vector<Comentario>();
	private RepositorioComentario repository;
    private RepositorioVideo repositoryvideo;
    public void publicarComentario(String value,int i) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
		throw new RuntimeException("Usuario no autenticado");
	}

	Youtuber usuario = (Youtuber) auth.getPrincipal();
    Comentario c = new Comentario();
    c.setEscrito_por(usuario);
    c.setTexto(value);
    Video v = repositoryvideo.findById(Long.valueOf(i))
                .orElseThrow(() -> new RuntimeException("Video no encontrado"));
    c.setSobre(v);
    repository.save(c);


         
    }
    public void eliminarComentario(int id) {
        Comentario comentario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        
        repository.delete(comentario);
         
    }
 
}