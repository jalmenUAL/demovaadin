package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

public interface iYoutuber extends iRegistrado {

    Video findVideoById(int id);

    void publicarVideo(com.example.demo.domain.Youtuber usuario, String titulo, String url);

    void publicarComentario(com.example.demo.domain.Youtuber usuario, Video video, String value);

    void actualizarConfiguracion(com.example.demo.domain.Youtuber usuario,String password, String avatar, String imagenFondo);

    void seguirUsuario(Youtuber seguidor, Youtuber seguido);

    void dejardeseguirUsuario(Youtuber seguidor, Youtuber seguido);

    void likeVideo(Youtuber usuario, Video video);

    void dislikeVideo(Youtuber usuario, Video video);

    void denunciarUsuario(Youtuber denunciante, Youtuber denunciado);

    void quitardenunciaUsuario(Youtuber denunciante, Youtuber denunciado);

    

}