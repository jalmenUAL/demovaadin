package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("GaleriadeVideos")
public class GaleradeVideos extends VerticalLayout {
    public Vector<GaleradeVideos_item> _item = new Vector<GaleradeVideos_item>();

    HorizontalLayout carrusel = new HorizontalLayout();

    GaleradeVideos() {
        // Span con el título de la galería
        Span tituloGaleria = new Span("Galería de Videos");
        tituloGaleria.getStyle().set("font-weight", "bold").set("font-size", "1.5em");
        add(tituloGaleria);

        add(carrusel);
    }
}