package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeUsuario")
public class PerfilAjenodeUsuario extends PerfilAjeno {

    public void Denunciar() {
        throw new UnsupportedOperationException();
    }

    public void Seguir() {
        throw new UnsupportedOperationException();
    }

    public PerfilAjenodeUsuario() {
        super();

        // Crear botones de denunciar y seguir
        Button btnDenunciar = new Button("Denunciar", e -> Denunciar());
        Button btnSeguir = new Button("Seguir", e -> Seguir());

        // Suponiendo que el layout de botones es el primer HorizontalLayout
        if (getComponentCount() > 0 && getComponentAt(0) instanceof HorizontalLayout) {
            HorizontalLayout botonesLayout = (HorizontalLayout) getComponentAt(0);
            botonesLayout.add(btnDenunciar, btnSeguir);
        }
    }
}