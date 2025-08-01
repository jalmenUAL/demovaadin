package com.example.demo.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Buscar")
public class Buscar extends VerticalLayout{
	public Inicio _inicio;
	public ResultadodeBusqueda _resultadodeBusqueda;

	public void ResultadodeBusqueda() {
		throw new UnsupportedOperationException();
	}
	
	Buscar(){

TextField buscar = new TextField();
buscar.setPlaceholder("Introduzca el nombre del video que quiere buscar");
add(buscar);
Button button = new Button("Buscar");
buscar(buscar.getValue());

button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
add(button);
buscar.getStyle().setWidth("100%");
 
	}

	private void buscar(String string) {
		// TODO Auto-generated method stub
		
	}
};

