package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("PerfilPropio")

public class PerfilPropio extends Perfil {

    public Youtuber _youtuber;
    public PublicarVideo _publicarVideo;
    public Configuracion _configuracion;

    public PerfilPropio() {
        // === Crear botones ===
        Button publicarButton = new Button("📤 Publicar video", event -> PublicarVideo());
        Button configButton = new Button("⚙️ Configuración", event -> Configuracion());

        // Estilizar botones (opcional)
        publicarButton.getStyle()
            .set("background-color", "#0d6efd")
            .set("color", "white")
            .set("border-radius", "8px")
            .set("font-weight", "bold");

        configButton.getStyle()
            .set("background-color", "#6c757d")
            .set("color", "white")
            .set("border-radius", "8px")
            .set("font-weight", "bold");

        // === Layout de botones alineado a la derecha ===
        HorizontalLayout botonesHeader = new HorizontalLayout(publicarButton, configButton);
        botonesHeader.setWidthFull();
        botonesHeader.setJustifyContentMode(JustifyContentMode.END);
        botonesHeader.setPadding(true);

        // Agregar los botones al inicio de la vista
        topLayout.add(botonesHeader);
    }

    public void PublicarVideo() {
        Notification.show("Función de publicar video no implementada", 3000, Notification.Position.MIDDLE);
        // Aquí podrías abrir un formulario o navegar a una vista
    }

    public void Configuracion() {
        Notification.show("Función de configuración no implementada", 3000, Notification.Position.MIDDLE);
        // Aquí podrías navegar a Configuracion o mostrar un panel
    }
}