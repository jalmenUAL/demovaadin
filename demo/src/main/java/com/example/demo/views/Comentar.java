package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Comentar")
public class Comentar extends VerticalLayout {
	public VerComentariosdeYoutuber _verComentariosdeYoutuber;

	public Comentar() {
		TextField comentario = new TextField("Escribe un comentario");
		comentario.setWidth("100%");
		add(comentario);	
		Button comentar = new Button("Publicar Comentario");
		comentar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		comentar.addClickListener(e -> {
			publicar_comentario();
		});
		add(comentar);
		getStyle().setWidth("100%");
	}

	private void publicar_comentario() {
		// TODO Auto-generated method stub

	}
}
