package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

public interface iAdministrador extends iRegistrado {

 
    void eliminarComentario(Comentario comentario);

    List<com.example.demo.domain.Youtuber> buscarDenunciados();

    List<Video> getAllVideos();

    void borrarVideo(Video video);

    void bloquearUsuario(Youtuber usuario);

    void desbloquearUsuario(Youtuber usuario);

}