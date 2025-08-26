package com.example.demo.service;

import java.util.List;


import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;


public interface iYoutuber extends iRegistrado {

    void publicarComentario(String value, int id);

    void actualizarConfiguracion(String value, String src, String src2);

    void publicarVideo(String value, String value2);

   

    void denunciarUsuario(String ormid);
    void seguirUsuario(String ormid);
    Youtuber findYoutuberById(String username);

    void likeVideo(int id);

    List<Video> getYoutuberVideos(String login);

    void dislikeVideo(int id);

    



}