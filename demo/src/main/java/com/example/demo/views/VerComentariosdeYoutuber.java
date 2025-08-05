package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;


@Route("VerComentariosdeYoutuber")
public class VerComentariosdeYoutuber extends VerComentarios {

    public VerComentariosdeYoutuber() {
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
        // Acción simulada: reemplaza esto por la lógica real
        Notification.show("Función de comentar aún no implementada", 3000, Notification.Position.MIDDLE);

        // Aquí podrías abrir un formulario de comentario o redirigir a otra vista
    }
}