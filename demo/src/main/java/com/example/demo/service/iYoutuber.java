package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;

@Service
public interface iYoutuber extends iRegistrado {

    void publicarComentario(String value);

    void actualizarConfiguracion(String value, String value2, String src, String src2);
	
	 
}