package com.example.demo.views;

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
TextField textField = new TextField("Text field");
EmailField email = new EmailField("Email");
add(email, textField);
}}
