package com.example.demo.views;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.component.html.Paragraph;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("comentar")
public class comentar extends VerticalLayout {
	public VerComentariosdeYoutuber _verComentariosdeYoutuber;
public comentar() {
TextField textField = new TextField("Escribe un comentario");
textField.setWidth("100%");
add(textField);
getStyle().setWidth("100%");
Button button = new Button("Publicar Comentario");
button.addClickListener(e -> {publicar_comentario();
});
add(button);
}
private void publicar_comentario() {
	// TODO Auto-generated method stub
	
}
}
