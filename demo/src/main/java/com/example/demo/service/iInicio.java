package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

public interface iInicio {

    List<Video> buscar(String texto);

    List<Video> getUltimosVideos();

    Video findVideoById(Integer parameter);

    Youtuber findYoutuberById(String parameter);

    List<Video> getVideosRelacionados(int id);

}