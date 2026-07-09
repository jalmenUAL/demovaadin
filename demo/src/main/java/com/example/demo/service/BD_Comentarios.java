package com.example.demo.service;

import java.util.Set;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

import jakarta.transaction.Transactional;

@Service

public class BD_Comentarios {

    public BDPrincipal _en;
    public Vector<Comentario> _comentarios = new Vector<Comentario>();
    private RepositorioComentario repository;

    public BD_Comentarios(RepositorioComentario comentariosRepository) {
        repository = comentariosRepository;

    }

    public void publicarComentario(Youtuber usuario, Video video, String value) {
        Comentario c = new Comentario();
        c.setEscrito_por(usuario);
        c.setTexto(value);
        c.setSobre(video);
        repository.save(c);

    }

    public void eliminarComentario(Comentario comentario) {
        repository.delete(comentario);
    }

@Transactional
    public void borrarComentariosDeVideo(Video video) {
        // Obtener todos los comentarios del video
        Set<Comentario> comentarios = video.getTiene_comentarios();

        // Eliminar cada comentario
        for (Comentario comentario : comentarios) {
            repository.delete(comentario);
        }
    }

}