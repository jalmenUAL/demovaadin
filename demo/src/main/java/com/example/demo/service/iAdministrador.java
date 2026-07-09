package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Video;

public interface iAdministrador extends iRegistrado {

    void eliminarComentario(Integer idComentario);

    List<com.example.demo.domain.Youtuber> buscarDenunciados();

    List<Video> getAllVideos();

    void borrarVideo(Integer idVideo);

    void bloquearUsuario(String idYoutuber);

    void desbloquearUsuario(String idYoutuber);

}