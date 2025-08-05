package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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
        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

         topLayout.add(btnSeguir,btnDenunciar);
    }
}