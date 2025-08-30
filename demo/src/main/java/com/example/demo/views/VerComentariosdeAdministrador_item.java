package com.example.demo.views;

import com.example.demo.domain.Comentario;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentariosdeAdministrador_item")
public class VerComentariosdeAdministrador_item extends VerComentarios_item {

    public iAdministrador iAdministrador;
    public Button eliminarButton;

    public VerComentariosdeAdministrador_item(iAdministrador iAdministrador, Comentario comentario) {
        super(comentario);
        this.iAdministrador = iAdministrador;
        // Crear botón "Eliminar"
        eliminarButton = new Button("Eliminar", event -> eliminar());

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
        iAdministrador.eliminarComentario(comentario.getORMID());
    }
}