package com.example.demo.views;


import java.util.Vector;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Videosrelacionados")

public class Videosrelacionados extends VerticalLayout{
	public VerVideo _verVideo;
	public Vector<Videosrelacionados_item> _item = new Vector<Videosrelacionados_item>();
 

    public Videosrelacionados() {
        setWidthFull();
        setPadding(true);
        setSpacing(false); // Usamos separadores en lugar de spacing

        for (int i = 0; i < 6; i++) {
            Videosrelacionados_item item = new Videosrelacionados_item();
            item.getStyle()
                .set("padding", "10px")
                .set("background-color", "#f9f9f9")
                .set("border-radius", "6px")
                .set("box-shadow", "0 1px 3px rgba(0,0,0,0.1)");

            add(item);

            // Añadir línea separadora excepto después del último item
            if (i < 5) {
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


