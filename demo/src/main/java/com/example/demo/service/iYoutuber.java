package com.example.demo.service;

import java.util.List;


import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;


public interface iYoutuber extends iRegistrado {

    void publicarComentario(String value);

    void actualizarConfiguracion(String value, String src, String src2);

    void publicarVideo(String value, String value2);

    List<Video> cargarUltimosVideos(String login);

    void denunciarUsuario(String ormid);
    void seguirUsuario(String ormid);
   com.example.demo.domain.Youtuber findYoutuberById(String username);

}