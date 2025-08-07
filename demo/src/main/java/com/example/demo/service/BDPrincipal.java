package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;
import com.example.demo.domain.Registrado;
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
        _comentarios = new BD_Comentarios(comentariosRepository, youtuberRepository);
        _administradores = new BD_Administradores(administradoresRepository);
    }

    @Override
    public List<Video> buscar(String texto) {
        // TODO Auto-generated method stub
       return _videos.buscar(texto);
    }

    @Override
    public Registrado Login(String username, String password) {
        if (_administradores.autenticar(username, password)!= null) {
            return  _administradores.autenticar(username, password);
        } else if (_youtubers.autenticar(username, password)!= null) {
            return  _youtubers.autenticar(username, password);
        }
        return null;
    }

    @Override
    public void publicarComentario(String value) {
        _comentarios.publicarComentario(value);
    }

    @Override
    public void actualizarConfiguracion(String value, String value2, String src, String src2) {
        _youtubers.actualizarConfiguracion(value, value2, src, src2);
    }

    @Override
    public void bloquearUsuario(String ormid) {
        _youtubers.bloquearUsuario(ormid);
    }

    @Override
    public void publicarVideo(String value, String value2) {
        _videos.publicarVideo(value, value2);
    }

    @Override
    public void registrar(String login, String password, String avatarUrl, String fondoUrl) {
        _youtubers.registrar(login, password, avatarUrl, fondoUrl);
    }

    @Override
    public List<Video> getUltimosVideos() {
        // TODO Auto-generated method stub
        return _videos.getUltimosVideos();
    }

    @Override
    public List<Video> cargarUltimosVideos(String login) {
        // TODO Auto-generated method stub
        return _youtubers.cargarUltimosVideos(login);
    }

    @Override
    public void eliminarComentario(int id) {
        // TODO Auto-generated method stub
        _comentarios.eliminarComentario(id);
    }

    @Override
    public List<Youtuber> buscarDenunciados() {
        // TODO Auto-generated method stub
        return _youtubers.buscarDenunciados();
    }

}