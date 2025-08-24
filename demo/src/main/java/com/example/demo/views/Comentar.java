package com.example.demo.views;

import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@Route("Comentar")
@RolesAllowed("ROLE_YOUTUBER")
public class Comentar extends VerticalLayout implements HasUrlParameter<String> {
    public VerComentariosdeYoutuber _verComentariosdeYoutuber;
    private TextField campoComentario;
    public iYoutuber _iYoutuber;
    public int id;

    public Comentar(iYoutuber iYoutuber) {
        this._iYoutuber = iYoutuber;
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
            publicar_comentario();
            campoComentario.clear();  // Limpia el campo tras publicar
        });

        add(campoComentario, btnPublicar);
    }

    private void publicar_comentario() {
        _iYoutuber.publicarComentario(campoComentario.getValue(),id);
        UI.getCurrent().getPage().getHistory().back();
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
         id = Integer.valueOf(parameter);
    }
}
