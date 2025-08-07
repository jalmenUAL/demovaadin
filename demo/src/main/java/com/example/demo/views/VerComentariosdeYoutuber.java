package com.example.demo.views;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.Comentario;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;


@Route("VerComentariosdeYoutuber")
public class VerComentariosdeYoutuber extends VerComentarios {

    public VerComentariosdeYoutuber(Set<Comentario> comentarios) {
        super(comentarios);
        // Crear botón "Comentar"
        Button comentarButton = new Button("Comentar", event -> comentar());

        // Estilo del botón
        comentarButton.getStyle()
            .set("background-color", "#28a745") // verde
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

        // Layout para centrar el botón
        HorizontalLayout centrarLayout = new HorizontalLayout(comentarButton);
        centrarLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centrarLayout.setWidthFull();

        // Agregar botón a la vista
        add(centrarLayout);
    }

    public void comentar() {
       UI.getCurrent().getPage().setLocation("Comentar");
         
    }
}