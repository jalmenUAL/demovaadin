package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

public interface iYoutuber extends iRegistrado {

    Video findVideoById(int idVideo);

    void publicarVideo(String loginYoutuber, String titulo, String url);

    void publicarComentario(String loginYoutuber, Video video, String value);

    void actualizarConfiguracion(String loginYoutuber, String password, String avatar, String imagenFondo);

    void seguirUsuario(String loginSeguidor, String loginSeguido);

    void dejardeseguirUsuario(String loginSeguidor, String loginSeguido);

    void likeVideo(String loginYoutuber, Integer idVideo);

    void dislikeVideo(String loginYoutuber, Integer idVideo);

    void denunciarUsuario(String loginDenunciante, String loginDenunciado);

    void quitardenunciaUsuario(String loginDenunciante, String loginDenunciado);

}