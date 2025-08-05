package com.example.demo.views;

import com.vaadin.flow.component.html.Paragraph;

import com.vaadin.flow.component.avatar.Avatar;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentarios_item")

public class VerComentarios_item extends VerticalLayout{
	public VerComentarios _verComentarios;
	public PerfilAjeno _perfilAjeno;

	public void PerfilAjeno() {
		throw new UnsupportedOperationException();
	}
public VerComentarios_item() {
        setPadding(true);
        setSpacing(true);
        setWidthFull();
        setAlignItems(Alignment.START);

        // Avatar
        Avatar avatar = new Avatar();
        avatar.setImage("https://avatars.githubusercontent.com/u/50332351?v=4");
        avatar.setWidth("50px");
        avatar.setHeight("50px");

        // Comentario en un layout vertical para mejor estructura
        VerticalLayout comentarioLayout = new VerticalLayout();
        comentarioLayout.setPadding(false);
        comentarioLayout.setSpacing(false);
        comentarioLayout.setWidthFull();

        Paragraph comentario = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        comentario.getStyle()
            .set("margin", "0")
            .set("font-size", "0.9em")
            .set("color", "#333");

        comentarioLayout.add(comentario);

        // Añadir avatar y comentario al layout horizontal
        add(avatar, comentarioLayout);
    }
}
