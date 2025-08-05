package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeAdministrador")
public class PerfilAjenodeAdministrador extends PerfilAjeno {
    private Button btnBloquear;

    public void Bloquear() {
        btnBloquear.setEnabled(false); // Deshabilitar el botón tras bloquear
        btnBloquear.setText("Usuario bloqueado"); // Cambiar el texto del botón
        btnBloquear.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
    }

    public PerfilAjenodeAdministrador() {
        super();

        // Crear botón de bloquear usuario
        btnBloquear = new Button("Bloquear usuario", e -> Bloquear());
        btnBloquear.addThemeVariants(ButtonVariant.LUMO_ERROR); // Botón rojo

        // Buscar el layout de botones en la vista padre y añadir el nuevo botón
        // Suponiendo que el layout de botones es el primer HorizontalLayout
         topLayout.add(btnBloquear);
    }
}