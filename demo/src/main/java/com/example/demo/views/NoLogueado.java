package com.example.demo.views;

//import basededatos.iNoLogueado;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("NoLogueado")
public class NoLogueado extends Inicio {
//	public iNoLogueado _iNoLogueado;
	public Login _login;
	public Registrar _registrar;

	public void Login() {
		throw new UnsupportedOperationException();
	}

	public void Registrar() {
		throw new UnsupportedOperationException();
	}
public NoLogueado() {
    Paragraph loremIpsumDolorSitAm = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
    loremIpsumDolorSitAm.addClassNames(LumoUtility.FontSize.LARGE);
    add(loremIpsumDolorSitAm);
}
}
