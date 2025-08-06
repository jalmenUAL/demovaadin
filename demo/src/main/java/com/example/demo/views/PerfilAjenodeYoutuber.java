package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeYoutuber")
public class PerfilAjenodeYoutuber extends PerfilAjeno {

    private Button btnDenunciar;
    private Button btnSeguir;

    public void Denunciar() {
         
        btnDenunciar.setEnabled(false); // Deshabilitar el botón tras la denuncia
        btnDenunciar.setText("Denunciado"); // Cambiar el texto del botón
        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
    }

    public void Seguir() {
        btnSeguir.setEnabled(false); // Deshabilitar el botón tras la denuncia
        btnSeguir.setText("Siguiendo"); // Cambiar el texto del botón
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
         
    }

    public PerfilAjenodeYoutuber() {
        super();

        // Crear botones de denunciar y seguir
        btnDenunciar = new Button("Denunciar", e -> Denunciar());
        btnSeguir = new Button("Seguir", e -> Seguir());
        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        topLayout.add(btnSeguir,btnDenunciar);
    }
}