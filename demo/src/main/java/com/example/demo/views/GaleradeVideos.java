package com.example.demo.views;

import java.util.List;
import java.util.Vector;

import com.example.demo.domain.Video;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("GaleriadeVideos")
public class GaleradeVideos extends VerticalLayout {
    public Vector<GaleradeVideos_item> _item = new Vector<GaleradeVideos_item>();

    HorizontalLayout carrusel = new HorizontalLayout();

   public GaleradeVideos(List<Video> videos) {
        // Estilo general centrado
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.START);  // si quieres que el carrusel esté más arriba

        // Título estilizado
        H2 tituloGaleria = new H2("🎥 Galería de Videos");
        tituloGaleria.getStyle()
            .set("color", "#2c3e50")
            .set("margin-top", "20px")
            .set("margin-bottom", "10px");

        // Estilo del carrusel
        carrusel.setSpacing(true);
        carrusel.setPadding(true);
        carrusel.setWidthFull();
        carrusel.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        // Agregar al layout principal
        add(tituloGaleria, carrusel);
    }
}