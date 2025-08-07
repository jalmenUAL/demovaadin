package com.example.demo.views;

import java.time.LocalDate;
import java.time.ZoneId;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("ResultadodeBusqueda_item")
public class ResultadodeBusqueda_item extends GaleradeVideos_item {

    public ResultadodeBusqueda_item(Video video ) {
         super(video);
         

    }
}  