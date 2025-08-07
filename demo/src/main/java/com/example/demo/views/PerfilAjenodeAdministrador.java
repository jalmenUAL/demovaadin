package com.example.demo.views;

import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeAdministrador")
public class PerfilAjenodeAdministrador extends PerfilAjeno {
    private Button btnBloquear;
    private iAdministrador iAdministrador;
     


    public void Bloquear() {
        btnBloquear.setEnabled(false); // Deshabilitar el botón tras bloquear
        btnBloquear.setText("Usuario bloqueado"); // Cambiar el texto del botón
        btnBloquear.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar a variante de contraste
        iAdministrador.bloquearUsuario(_usuario.getORMID()); // Lógica para bloquear al usuario

    }

    public PerfilAjenodeAdministrador(iAdministrador iAdministrador,
                                      com.example.demo.domain.Youtuber youtuber) {
        super(youtuber);
        this.iAdministrador = iAdministrador;
         

        // Crear botón de bloquear usuario
        btnBloquear = new Button("Bloquear usuario", e -> Bloquear());
        btnBloquear.addThemeVariants(ButtonVariant.LUMO_ERROR); // Botón rojo

        // Buscar el layout de botones en la vista padre y añadir el nuevo botón
        // Suponiendo que el layout de botones es el primer HorizontalLayout
         topLayout.add(btnBloquear);
    }
}