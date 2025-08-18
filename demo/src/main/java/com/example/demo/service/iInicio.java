package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Video;

@Service
public interface iInicio {

    List<Video> buscar(String texto);

    List<Video> getUltimosVideos();

    
}