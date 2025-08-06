package com.example.demo.views;

import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Comentar")
public class Comentar extends VerticalLayout {
    public VerComentariosdeYoutuber _verComentariosdeYoutuber;
    private TextField campoComentario;

    public Comentar(iYoutuber iYoutuber) {
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setAlignItems(Alignment.STRETCH);  // Para que el TextField y botón ocupen todo el ancho

       campoComentario = new TextField("Escribe un comentario");
        campoComentario.setWidthFull();

        Button btnPublicar = new Button("Publicar Comentario");
        btnPublicar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnPublicar.setWidthFull();

        btnPublicar.addClickListener(e -> {
            publicar_comentario(iYoutuber);
            campoComentario.clear();  // Limpia el campo tras publicar
        });

        add(campoComentario, btnPublicar);
    }

    private void publicar_comentario(iYoutuber iYoutuber) {
        iYoutuber.publicarComentario(campoComentario.getValue());
        UI.getCurrent().getPage().getHistory().back();
    }
}
