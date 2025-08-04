package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Buscar")
public class Buscar extends VerticalLayout {
	public Inicio _inicio;
	public ResultadodeBusqueda _resultadodeBusqueda;

	public void ResultadodeBusqueda() {
		_resultadodeBusqueda = new ResultadodeBusqueda();
		add(_resultadodeBusqueda);
	}

	Buscar() {

		TextField textobuscar = new TextField();
		textobuscar.setPlaceholder("Introduzca el nombre del video que quiere buscar");
		textobuscar.getStyle().setWidth("100%");
		add(textobuscar);

		Button botonbuscar = new Button("Buscar");
		botonbuscar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		add(botonbuscar);
		botonbuscar.addClickListener(e -> {
			buscar(textobuscar.getValue());
		});

	}

	private void buscar(String string) {
		// TODO Auto-generated method stub

	}
};
