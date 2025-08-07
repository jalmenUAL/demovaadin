package com.example.demo.views;

import com.example.demo.domain.Video;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("VerVideodeYoutuber")

public class VerVideodeYoutuber extends VerVideo {

    public VerVideodeYoutuber(Video video) {
        super(video);
        // Crear botón de Like
        Button likeButton = new Button("👍 Me gusta", event -> like());

        // Estilizar el botón (opcional)
        likeButton.getStyle()
            .set("background-color", "#0d6efd") // azul
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

        // Añadir el botón a donde quieras (por ejemplo, debajo del video)
        frame_y_comentarios.add(likeButton);
    }

    public void like() {
        // Evento cuando se hace clic en "Me gusta"
        Notification.show("¡Te ha gustado el video!", 3000, Notification.Position.MIDDLE);

        // Aquí puedes conectar lógica real (ej: sumar un like, llamar a servicio, etc.)
    }
}