package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;

@Service
public interface iYoutuber extends iRegistrado {

    void publicarComentario(String value);

    void actualizarConfiguracion(String value, String value2, String src, String src2);

    void publicarVideo(String value, String value2);

    List<Video> cargarUltimosVideos(String login);
	
	 
}