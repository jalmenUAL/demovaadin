package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeAdministrador")
public class PerfilAjenodeAdministrador extends PerfilAjeno {

    public void Bloquear() {
        throw new UnsupportedOperationException();
    }

    public PerfilAjenodeAdministrador() {
        super();

        // Crear botón de bloquear usuario
        Button btnBloquear = new Button("Bloquear usuario", e -> Bloquear());

        // Buscar el layout de botones en la vista padre y añadir el nuevo botón
        // Suponiendo que el layout de botones es el primer HorizontalLayout
        if (getComponentCount() > 0 && getComponentAt(0) instanceof HorizontalLayout) {
            HorizontalLayout botonesLayout = (HorizontalLayout) getComponentAt(0);
            botonesLayout.add(btnBloquear);
        }
    }
}