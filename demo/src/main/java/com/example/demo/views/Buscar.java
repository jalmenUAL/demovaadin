package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.Video;
import com.example.demo.service.iInicio;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("Buscar")
public class Buscar extends VerticalLayout {
	public Inicio _inicio;
	public ResultadodeBusqueda _resultadodeBusqueda;
	private TextField textobuscar;
	private VerticalLayout contenido = new VerticalLayout();

	public void ResultadodeBusqueda() {
		_resultadodeBusqueda = new ResultadodeBusqueda();
		contenido.add(_resultadodeBusqueda);
	}

	Buscar() {

		textobuscar = new TextField();
		textobuscar.setPlaceholder("Introduzca el nombre del video que quiere buscar");
		textobuscar.setWidthFull(); // Ocupa todo el espacio disponible

		Button botonbuscar = new Button("Buscar");
		botonbuscar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		botonbuscar.addClickListener(e -> {
			buscar();
		});

		HorizontalLayout buscarLayout = new HorizontalLayout(textobuscar, botonbuscar);
		buscarLayout.setWidthFull(); // El layout ocupa todo el ancho
		buscarLayout.setFlexGrow(1, textobuscar); // El textfield crece

		contenido.add(buscarLayout);
		add(contenido);
	}

	private void buscar() {
		

		ResultadodeBusqueda();

	}
};
