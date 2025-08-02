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
    Avatar avatar = new Avatar();
    avatar.setImage("https://avatars.githubusercontent.com/u/50332351?v=4");
    add(avatar);
Paragraph loremIpsumDolorSitAm = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
add(loremIpsumDolorSitAm);
}
}
