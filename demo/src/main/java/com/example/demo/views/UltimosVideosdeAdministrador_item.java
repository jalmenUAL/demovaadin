package com.example.demo.views;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("UltimosVideosdeAdministrador_item")
public class UltimosVideosdeAdministrador_item extends UltimosVideos_item {

    public UltimosVideosdeAdministrador_item(Video video) {
        super(video);
        
    }
}