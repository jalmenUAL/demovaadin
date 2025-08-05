package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentariosdeAdministrador_item")
public class VerComentariosdeAdministrador_item extends VerComentarios_item {

    public VerComentariosdeAdministrador_item() {
        // Crear botón "Eliminar"
        Button eliminarButton = new Button("Eliminar", event -> eliminar());

        // Estilo: color azul, texto blanco, bordes redondeados
        eliminarButton.getStyle()
            .set("background-color", "#007BFF")  // azul
            .set("color", "white")              // texto blanco
            .set("border-radius", "8px")        // bordes redondeados
            .set("padding", "10px 20px")        // espaciado interno
            .set("font-weight", "bold");

        // Contenedor centrado
        HorizontalLayout centrarLayout = new HorizontalLayout(eliminarButton);
        centrarLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centrarLayout.setWidthFull();

        // Agregar a la vista
        add(centrarLayout);
    }

    public void eliminar() {
        // Acción simulada
        Notification.show("Comentario eliminado", 3000, Notification.Position.MIDDLE);
        // Aquí iría la lógica real (ej: eliminar de la base de datos)
    }
}