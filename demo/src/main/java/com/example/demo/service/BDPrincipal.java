package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Registrado;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

@Service
public class BDPrincipal implements iNoLogueado, iYoutuber, iAdministrador, iRegistrado, iInicio {
    public BD_Videos _videos;
    public BD_Comentarios _comentarios;
    public BD_Youtubers _youtubers;
    public BD_Administradores _administradores;

    /* Imprescindible pasar las BDs a BD Principal */
    public BDPrincipal(BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers, BD_Administradores administradores) {
       this._youtubers = youtubers;
        this._administradores = administradores;
        this._videos = videos;
        this._comentarios = comentarios;
    }

     

    @Override
    public List<Video> buscar(String texto) {
       
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
    public void publicarComentario(String value,int i) {
        _comentarios.publicarComentario(value,i);
    }

    @Override
    public void actualizarConfiguracion(String value, String src, String src2) {
        _youtubers.actualizarConfiguracion(value, src, src2);
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
         
        return _videos.getUltimosVideos();
    }

    @Override
    public List<Video> getYoutuberVideos(String login) {

        return _youtubers.getYoutuberVideos(login);
    }

    @Override
    public void eliminarComentario(int id) {
         
        _comentarios.eliminarComentario(id);
    }

    @Override
    public List<Youtuber> buscarDenunciados() {
         
        return _youtubers.buscarDenunciados();
    }



    @Override
    public void denunciarUsuario(String ormid) {
         _youtubers.denunciarUsuario(ormid);
    }



    @Override
    public void seguirUsuario(String ormid) {
        _youtubers.seguirUsuario(ormid);
    }



 



    @Override
    public Video findVideoById(Long parameter) {
        
        return _videos.findVideoById(parameter);
    }


 



    @Override
    public void likeVideo(int id) {
        _videos.likeVideo(id);
    }



    @Override
    public List<Video> getAllVideos() {
        return _videos.getAllVideos();
    }



    @Override
    public Set<Youtuber> getYoutubersSeguidos(String parameter) {
        return _youtubers.getYoutubersSeguidos(parameter);
    }



    @Override
    public List<Video> getVideosRelacionados(int id) {
         return _videos.getVideosRelacionados(id);
    }



    @Override
    public void borrarVideo(int id) {
        _videos.borrarVideo(id);
    }


 



    @Override
    public Youtuber findYoutuberById(String username) {
        return _youtubers.findYoutuberById(username);
    }



    @Override
    public void bloquear(String login) {
         _youtubers.bloquearUsuario(login);
    }



    @Override
    public void dislikeVideo(int id) {
        _videos.dislikeVideo(id);
    }


 
 

}