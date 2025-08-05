package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Comentar")
public class Comentar extends VerticalLayout {
    public VerComentariosdeYoutuber _verComentariosdeYoutuber;

    public Comentar() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setAlignItems(Alignment.STRETCH);  // Para que el TextField y botón ocupen todo el ancho

        TextField campoComentario = new TextField("Escribe un comentario");
        campoComentario.setWidthFull();

        Button btnPublicar = new Button("Publicar Comentario");
        btnPublicar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnPublicar.setWidthFull();

        btnPublicar.addClickListener(e -> {
            publicar_comentario();
            campoComentario.clear();  // Limpia el campo tras publicar
        });

        add(campoComentario, btnPublicar);
    }

    private void publicar_comentario() {
        UI.getCurrent().getPage().getHistory().back();
    }
}
