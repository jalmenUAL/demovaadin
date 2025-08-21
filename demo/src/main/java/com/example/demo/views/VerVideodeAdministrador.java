package com.example.demo.views;

import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("VerVideodeAdministrador")

public class VerVideodeAdministrador extends VerVideo {

    iAdministrador iAdministrador;

    public VerVideodeAdministrador(com.example.demo.service.iAdministrador iAdministrador) {
        super(iAdministrador);
        this.iAdministrador = iAdministrador;
        // Crear botón de borrar
        Button borrarButton = new Button("🗑️ Borrar video", event -> borrar());

        // Estilo opcional
        borrarButton.getStyle()
            .set("background-color", "#dc3545") // rojo
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

        // Añadir al layout del video (por ejemplo debajo del iframe)
        frame_y_comentarios.add(borrarButton);
    }

@Override
    public void VerComentarios() {

		_verComentarios = new VerComentariosdeAdministrador(iAdministrador,video.getTiene_comentarios());
        comentarios.add(_verComentarios);
		frame_y_comentarios.add(comentarios);
	}

    public void borrar() {
        // Por ahora, solo muestra una notificación
        Notification.show("Función de borrar no implementada aún", 3000, Notification.Position.MIDDLE);

        // Aquí podrías poner la lógica real de borrado, por ejemplo:
        // videoService.borrarVideo(videoId);
        // UI.getCurrent().navigate("pagina-principal");
    }
}