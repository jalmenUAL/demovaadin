package com.example.demo.service;

import java.util.Optional;
import java.util.Vector;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Youtuber;

@Service

public class BD_Comentarios {
	public BD_Comentarios(RepositorioComentario comentariosRepository, RepositorioYoutuber youtuberRepository) {
        repository = comentariosRepository;
        repositorioYoutuber = youtuberRepository;
    }

    
    public BDPrincipal _en;
	public Vector<Comentario> _comentarios = new Vector<Comentario>();
	private RepositorioComentario repository;
    private RepositorioYoutuber repositorioYoutuber;
    public void publicarComentario(String value) {
        Comentario comentario = new Comentario();
        comentario.setTexto(value);
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Youtuber> usuario = repositorioYoutuber.findByLogin(login);
        comentario.setEscrito_por(usuario.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        _comentarios.add(comentario);
        repository.save(comentario);
    }
    public void eliminarComentario(int id) {
        Comentario comentario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        repository.delete(comentario);
         
    }
}