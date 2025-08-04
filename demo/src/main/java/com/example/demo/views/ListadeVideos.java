package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("ListadeVideos")
public class ListadeVideos extends VerticalLayout {
    public Vector<ListadeVideos_item> _item = new Vector<ListadeVideos_item>();

    public ListadeVideos() {
        // Crear 6 items y mostrarlos en un grid de 2 filas x 3 columnas
        int filas = 2;
        int columnas = 3;
        int total = filas * columnas;

        for (int i = 0; i < total; i++) {
            _item.add(new ListadeVideos_item());
        }

        int index = 0;
        for (int f = 0; f < filas; f++) {
            HorizontalLayout fila = new HorizontalLayout();
            for (int c = 0; c < columnas; c++) {
                if (index < _item.size()) {
                    fila.add(_item.get(index));
                    index++;
                }
            }
            add(fila);
        }
    }
}