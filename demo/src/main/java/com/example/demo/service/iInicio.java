package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

public interface iInicio {

    List<Video> buscar(String texto);

    Video findVideoById(Integer id);

    Youtuber findYoutuberById(String id);

     List<Video> getUltimosVideos();

    List<Video> getVideosRelacionados(Video videob);

}