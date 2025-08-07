package com.example.demo.views;

import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeYoutuber")
public class PerfilAjenodeYoutuber extends PerfilAjeno {

    private Button btnDenunciar;
    private Button btnSeguir;

    public void Denunciar() {
        iAdministrador.denunciarUsuario(_usuario.getORMID());
        btnDenunciar.setEnabled(false); // Deshabilitar el botón tras la denuncia
        btnDenunciar.setText("Denunciado"); // Cambiar el texto del botón
        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
        
    }

    public void Seguir() {
        iAdministrador.seguirUsuario(_usuario.getORMID());
        btnSeguir.setEnabled(false); // Deshabilitar el botón tras la denuncia
        btnSeguir.setText("Siguiendo"); // Cambiar el texto del botón
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
         
    }

    public PerfilAjenodeYoutuber(iAdministrador iAdministrador,
                                 com.example.demo.domain.Youtuber youtuber) {
        super(youtuber);

        // Crear botones de denunciar y seguir
        btnDenunciar = new Button("Denunciar", e -> Denunciar());
        btnSeguir = new Button("Seguir", e -> Seguir());
        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        topLayout.add(btnSeguir,btnDenunciar);
    }
}