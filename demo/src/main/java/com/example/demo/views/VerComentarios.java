package com.example.demo.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.domain.Comentario;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentarios")

public class VerComentarios extends VerticalLayout {
    public VerVideo _verVideo;
    public List<VerComentarios_item> _item = new ArrayList<>();

    public VerComentarios(Set<Comentario>  comentarios) {

        setWidthFull();
        setPadding(true);
        setSpacing(false);  // Desactivamos spacing porque usaremos separadores
        setAlignItems(Alignment.STRETCH);
        List<Comentario> comentarios2 = new ArrayList<>(comentarios);

        for (int i = 0; i < comentarios2.size(); i++) {
            VerComentarios_item comentario = new VerComentarios_item(comentarios2.get(i));
            _item.add(comentario);
            add(comentario);

            // Añadir separador excepto después del último comentario
            if (i < comentarios.size() - 1) {
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