package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;
import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;

import java.util.List;

@Service
public class BDPrincipal implements iNoLogueado, iYoutuber, iAdministrador, iRegistrado, iInicio {
    public BD_Videos _videos;
    public BD_Comentarios _comentarios;
    public BD_Youtubers _youtubers;
    public BD_Administradores _administradores;

    public BDPrincipal(RepositorioVideo videorepository, RepositorioYoutuber youtuberRepository, RepositorioComentario comentariosRepository, RepositorioAdministrador administradoresRepository) {
        _videos = new BD_Videos(videorepository);
        _youtubers = new BD_Youtubers(youtuberRepository);
        _comentarios = new BD_Comentarios(comentariosRepository);
        _administradores = new BD_Administradores(administradoresRepository);
    }

    @Override
    public List<Video> buscar(String texto) {
        // TODO Auto-generated method stub
       return _videos.buscar(texto);
    }

}