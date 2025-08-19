package com.example.demo.service;

import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.RepositorioComentario;

@Service

public class BD_Comentarios {
	public BD_Comentarios(RepositorioComentario comentariosRepository) {
        repository = comentariosRepository;
         
    }

    
    public BDPrincipal _en;
	public Vector<Comentario> _comentarios = new Vector<Comentario>();
	private RepositorioComentario repository;
    public void publicarComentario(String value) {
         
    }
    public void eliminarComentario(int id) {
        Comentario comentario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        repository.delete(comentario);
         
    }
}