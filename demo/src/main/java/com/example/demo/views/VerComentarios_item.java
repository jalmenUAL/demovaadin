package com.example.demo.views;

import com.example.demo.domain.Comentario;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentarios_item")

public class VerComentarios_item extends VerticalLayout {
    public VerComentarios _verComentarios;
    public PerfilAjeno _perfilAjeno;
    Comentario comentario;

    public void PerfilAjeno() {
        UI.getCurrent().navigate(PerfilAjeno.class, comentario.getEscrito_por().getLogin());
    }

    public VerComentarios_item(Comentario comentario) {
        this.comentario = comentario;
        setPadding(true);
        setSpacing(true);
        setWidthFull();
        setAlignItems(Alignment.START);

        // Avatar
        Image avatar = new Image(comentario.getEscrito_por().getFotoPerfil(), "Avatar");
        avatar.setWidth("50px");
        avatar.setHeight("50px");
        avatar.getStyle().set("border-radius", "50%");
        
        

        avatar.addClickListener(e -> PerfilAjeno());

        Span nombreUsuario = new Span(comentario.getEscrito_por().getLogin());

        // Comentario en un layout vertical para mejor estructura
        VerticalLayout comentarioLayout = new VerticalLayout();
        comentarioLayout.setPadding(false);
        comentarioLayout.setSpacing(false);
        comentarioLayout.setWidthFull();

        Paragraph comentario_texto = new Paragraph(comentario.getTexto());
        comentario_texto.getStyle()
                .set("margin", "0")
                .set("font-size", "0.9em")
                .set("color", "#333");

        comentarioLayout.add(comentario_texto);

        // Añadir avatar y comentario al layout horizontal
        add(avatar, nombreUsuario, comentarioLayout);
    }
}
