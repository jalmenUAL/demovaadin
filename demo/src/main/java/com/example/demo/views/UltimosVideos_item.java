package com.example.demo.views;

import com.example.demo.domain.Video;
import com.vaadin.flow.component.messages.MessageList;

import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.router.Route;

@Route("UltimosVideos_item")

public class UltimosVideos_item extends GaleradeVideos_item {
    public UltimosVideos_item(Video video) {

        super(video);
         
    }
}
