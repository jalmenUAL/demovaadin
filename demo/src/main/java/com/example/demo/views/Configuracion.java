package com.example.demo.views;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.textfield.EmailField;

import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Configuracion")
public class Configuracion extends VerticalLayout{
	public PerfilPropio _perfilPropio;
	
	public Configuracion() {
H1 heading1 = new H1("Configuracion");
add(heading1);
EmailField login = new EmailField("Login");
TextField password = new TextField("Password");
add(login,password);
Button actualizar = new Button("Actualizar");
actualizar.addClickListener(event -> actualizar());
add(actualizar);

}

	private void actualizar() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
	}}
