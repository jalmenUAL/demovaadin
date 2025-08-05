package com.example.demo.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentarios")

public class VerComentarios extends VerticalLayout {
    public VerVideo _verVideo;
    public List<VerComentarios_item> _item = new ArrayList<>();

    public VerComentarios() {
        setWidthFull();
        setPadding(true);
        setSpacing(false);  // Desactivamos spacing porque usaremos separadores
        setAlignItems(Alignment.STRETCH);

        int totalComentarios = 3;
        for (int i = 0; i < totalComentarios; i++) {
            VerComentarios_item comentario = new VerComentarios_item();
            _item.add(comentario);
            add(comentario);

            // Añadir separador excepto después del último comentario
            if (i < totalComentarios - 1) {
                addSeparator();
            }
        }
    }

    private void addSeparator() {
        Div separator = new Div();
        separator.getStyle()
            .set("height", "1px")
            .set("background-color", "#ddd")
            .set("width", "100%")
            .set("margin", "8px 0");
        add(separator);
    }
}