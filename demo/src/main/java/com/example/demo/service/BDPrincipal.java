package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Comentario;
import com.example.demo.domain.Registrado;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

import jakarta.transaction.Transactional;

@Service
public class BDPrincipal implements iNoLogueado, iYoutuber, iAdministrador, iRegistrado, iInicio {
    public BD_Videos _videos;
    public BD_Comentarios _comentarios;
    public BD_Youtubers _youtubers;
    public BD_Administradores _administradores;

    /* Imprescindible pasar las BDs a BD Principal */
    public BDPrincipal(BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers,
            BD_Administradores administradores) {
        this._youtubers = youtubers;
        this._administradores = administradores;
        this._videos = videos;
        this._comentarios = comentarios;
    }

    @Override
     
    public Registrado Login(String username, String password) {
        if (_administradores.autenticar(username, password) != null) {
            return _administradores.autenticar(username, password);
        } else if (_youtubers.autenticar(username, password) != null) {
            return _youtubers.autenticar(username, password);
        }
        return null;
    }

    @Override
    public List<Video> buscar(String texto) {
        return _videos.buscar(texto);
    }

    @Override
    public void publicarVideo(Youtuber usuario, String titulo, String url) {
        _videos.publicarVideo(usuario, titulo, url);
    }

    @Override
    public void publicarComentario(Youtuber usuario, Video video, String value) {
        _comentarios.publicarComentario(usuario, video, value);
    }

    @Override
    public void registrar(String login, String password, String avatarUrl, String fondoUrl) {
        _youtubers.registrar(login, password, avatarUrl, fondoUrl);
    }

    @Override
    public void actualizarConfiguracion(Youtuber usuario, String password, String avatar, String imagenFondo) {
        _youtubers.actualizarConfiguracion(usuario, password, avatar, imagenFondo);
    }

    @Override
    public Youtuber findYoutuberById(String username) {
        return _youtubers.findYoutuberById(username);
    }

    @Override
    public Video findVideoById(Integer parameter) {
        return _videos.findVideoById(parameter);
    }

    @Override
    public List<Video> getAllVideos() {
        return _videos.getAllVideos();
    }

    @Override
    public List<Video> getUltimosVideos() {
        return _videos.getUltimosVideos();
    }
 

    @Override
    public List<Video> getVideosRelacionados(Video videob) {
        return _videos.getVideosRelacionados(videob);
    }

    @Override
    @Transactional
    public void borrarVideo(Video video) {
        Video managed = _videos.findVideoById(video.getId());
        _youtubers.borrarMeGustaDeTodosLosUsuarios(managed);
        _comentarios.borrarComentariosDeVideo(managed);
        _videos.borrarVideo(managed);
    }

    @Override
    public void eliminarComentario(Comentario comentario) {
        _comentarios.eliminarComentario(comentario);
    }

    @Override
    public List<Youtuber> buscarDenunciados() {
        return _youtubers.buscarDenunciados();
    }

    @Override
    public void denunciarUsuario(Youtuber denunciante, Youtuber denunciado) {
        _youtubers.denunciarUsuario(denunciante, denunciado);
    }

    @Override
    public void quitardenunciaUsuario(Youtuber denunciante, Youtuber denunciado) {
        _youtubers.quitardenunciaUsuario(denunciante, denunciado);
    }

    @Override
    public void seguirUsuario(Youtuber seguidor, Youtuber seguido) {
        _youtubers.seguirUsuario(seguidor, seguido);
    }

    @Override
    public void dejardeseguirUsuario(Youtuber seguidor, Youtuber seguido) {
        _youtubers.dejardeseguirUsuario(seguidor, seguido);
    }

    @Override
    public void likeVideo(Youtuber usuario, Video video) {
        _youtubers.likeVideo(usuario, video);
    }

    @Override
    public void dislikeVideo(Youtuber usuario, Video video) {
        _youtubers.dislikeVideo(usuario, video);
    }

    @Override
    public void bloquearUsuario(Youtuber usuario) {
        _youtubers.bloquearUsuario(usuario);
    }

    @Override
    public void desbloquearUsuario(Youtuber usuario) {
        _youtubers.desbloquearUsuario(usuario);
    }

    @Override
    public Video findVideoById(int id) {
        return _videos.findVideoById(id);
    }

}