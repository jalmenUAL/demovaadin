package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

public interface iYoutuber extends iRegistrado {

    void publicarVideo(String value, String value2);

    void publicarComentario(String value, int id);

    void actualizarConfiguracion(String value, String src, String src2);

    List<Video> getYoutuberVideos(String login);

    void seguirUsuario(String ormid);

    void dejardeseguirUsuario(String ormid);

    void likeVideo(int id);

    void dislikeVideo(int id);

    void denunciarUsuario(String ormid);

    void quitardenunciaUsuario(String ormid);

}