package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;

@Service
public interface iAdministrador extends iRegistrado {

    void bloquearUsuario(String ormid);
 

    void eliminarComentario(int id);

    List<com.example.demo.domain.Youtuber> buscarDenunciados();

    List<Video> getUltimosVideos();
   
}