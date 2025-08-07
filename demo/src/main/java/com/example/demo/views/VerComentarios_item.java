package com.example.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.example.demo.domain.Comentario;
import com.vaadin.flow.component.avatar.Avatar;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentarios_item")

public class VerComentarios_item extends VerticalLayout{
	public VerComentarios _verComentarios;
	public PerfilAjeno _perfilAjeno;
    Comentario comentario2;

	public void PerfilAjeno() {
		throw new UnsupportedOperationException();
	}
public VerComentarios_item(Comentario comentario2) {
        this.comentario2 = comentario2;
        setPadding(true);
        setSpacing(true);
        setWidthFull();
        setAlignItems(Alignment.START);

        // Avatar
        Avatar avatar = new Avatar();
        avatar.setImage(comentario2.getEscrito_por().getFotoPerfil()    );
        avatar.setWidth("50px");
        avatar.setHeight("50px");

        Span nombreUsuario = new Span(comentario2.getEscrito_por().getLogin());

        // Comentario en un layout vertical para mejor estructura
        VerticalLayout comentarioLayout = new VerticalLayout();
        comentarioLayout.setPadding(false);
        comentarioLayout.setSpacing(false);
        comentarioLayout.setWidthFull();

        Paragraph comentario =  new Paragraph(comentario2.getTexto());
        comentario.getStyle()
            .set("margin", "0")
            .set("font-size", "0.9em")
            .set("color", "#333");

        comentarioLayout.add(comentario);

        // Añadir avatar y comentario al layout horizontal
        add(avatar, nombreUsuario,comentarioLayout);
    }
}
