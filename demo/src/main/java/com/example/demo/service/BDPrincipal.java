package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;

import java.util.List;

@Service
public class BDPrincipal implements iNoLogueado, iYoutuber, iAdministrador, iRegistrado, iInicio {
    public BD_Videos _videos;
    public BD_Comentarios _comentarios;
    public BD_Youtubers _youtubers;
    public BD_Administradores _administradores;

    public BDPrincipal(RepositorioVideo videorepository) {
        _videos = new BD_Videos(videorepository);
    }

    // iYoutuber, iRegistrado, iInicio, iNoLogueado, iAdministrador

    // Ejemplo de implementación de métodos de iAdministrador
    @Override
    public void bloquearUsuarioPorLogin(String login) {
        // Implementa la lógica para bloquear usuario
        if (_youtubers != null) {
            _youtubers.bloquearPorLogin(login);
        }
    }

    @Override
    public List<Object> verDenunciasUsuarios() {
        // Implementa la lógica para ver denuncias
        if (_administradores != null) {
            return _administradores.obtenerDenuncias();
        }
        return List.of();
    }

    @Override
    public iAdministrador buscarAdministradorPorLoginYPassword(String login, String password) {
        // Implementa la lógica de búsqueda
        if (_administradores != null) {
            return _administradores.buscarPorLoginYPassword(login, password);
        }
        return null;
    }

    // Ejemplo de métodos ya presentes
    @Override
    public void publicar(String titulo, String url) {
        _videos.publicar(titulo, url);
    }

    @Override
    public List<Video> listar() {
        return _videos.listar();
    }


    // Implementa aquí los métodos de las otras interfaces según tu necesidad
}