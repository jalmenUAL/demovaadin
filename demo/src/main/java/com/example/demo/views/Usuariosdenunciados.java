package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

@Route("Usuariosdenunciados")
public class Usuariosdenunciados extends VerticalLayout{
    public Administrador _administrador;
    public Vector<Usuariosdenunciados_item> _item = new Vector<Usuariosdenunciados_item>();

    public Usuariosdenunciados() {
        // Título
        Span titulo = new Span("Usuarios denunciados");
        titulo.getStyle().set("font-weight", "bold").set("font-size", "1.5em");
        add(titulo);

        // Ejemplo: añadir 5 cards de usuarios denunciados en un layout horizontal
        HorizontalLayout cardsLayout = new HorizontalLayout();
        cardsLayout.setWidthFull();

        for (int i = 0; i < 5; i++) {
            Usuariosdenunciados_item item = new Usuariosdenunciados_item();
            _item.add(item);

            Div card = new Div(item);
            card.getStyle()
                .set("border", "1px solid #ccc")
                .set("border-radius", "8px")
                .set("padding", "16px")
                .set("margin-right", "12px")
                .set("box-shadow", "0 2px 8px rgba(0,0,0,0.05)")
                .set("min-width", "200px");

            cardsLayout.add(card);
        }
        add(cardsLayout);
    }
}