package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

import jakarta.transaction.Transactional;

@Service

public class BD_Videos {
    public BDPrincipal _en;
    public Vector<Video> _videos = new Vector<Video>();

    private RepositorioVideo videorepository;

    /* Necesita el repositorio de videos, de youtubers y de comentarios */

    public BD_Videos(RepositorioVideo videorepository) {
        this.videorepository = videorepository;

    }

    public Video findVideoById(Integer id) {
        return videorepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video no encontrado"));
    }

    public java.util.List<Video> buscar(String texto) {
        List<Video> busqueda = videorepository.findAll();
        return busqueda.stream()
                .filter(video -> video.getTitulo().contains(texto))
                .toList();
    }

    public void publicarVideo(Youtuber usuario, String titulo, String url) {
        Video video = new Video();
        video.setTitulo(titulo);
        video.setUrl(url);
        video.setEs_de(usuario);
        videorepository.save(video);

    }

    public List<Video> getAllVideos() {
        return videorepository.findAll();
    }

    public java.util.List<Video> getUltimosVideos() {
        java.util.List<Video> UltimosVideos = videorepository.findAll();
        if (UltimosVideos.size() > 10) {
            UltimosVideos = UltimosVideos.subList(0, 10);
        }
        return UltimosVideos;
    }

    public List<Video> getVideosRelacionados(Video videob) {

        List<String> palabras = Arrays.stream(videob.getTitulo().split("\s+"))
                .map(String::toLowerCase)
                .toList();

        List<Video> busqueda = videorepository.findAll();

        return busqueda.stream()
                // Excluir el propio video
                .filter(video -> !(video.getId() == videob.getId()))
                // Comparar títulos ignorando mayúsculas
                .filter(video -> {
                    String titulo = video.getTitulo().toLowerCase();
                    return palabras.stream().anyMatch(titulo::contains);
                })
                .toList();
    }

    /* Los ManyToMany hay que borrarlos manualmente como se hace aquí */

    @Transactional

    public void borrarVideo(Video video) {
        videorepository.delete(video);
    }

}