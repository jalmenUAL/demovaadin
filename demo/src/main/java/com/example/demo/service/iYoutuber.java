package com.example.demo.service;

import java.util.List;


import com.example.demo.domain.Video;


public interface iYoutuber extends iRegistrado {

    void publicarComentario(String value);

    void actualizarConfiguracion(String value, String value2, String src, String src2);

    void publicarVideo(String value, String value2);

    List<Video> cargarUltimosVideos(String login);

    static void seguirUsuario(String ormid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seguirUsuario'");
    }

    static void denunciarUsuario(String ormid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'denunciarUsuario'");
    }
	
	 
}