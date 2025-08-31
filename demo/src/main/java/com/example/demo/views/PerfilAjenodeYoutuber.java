package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Youtuber;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeYoutuber")
public class PerfilAjenodeYoutuber extends PerfilAjeno {

    private Button btnDenunciar;
    private Button btnSeguir;
    iYoutuber _iYoutuber;

    /* Accede a la base de datos a través de iYoutuber */

    public PerfilAjenodeYoutuber(iYoutuber iYoutuber) {
        super(iYoutuber);
        this._iYoutuber = iYoutuber;

        // Crear botones de denunciar y seguir
        btnDenunciar = new Button("Denunciar", e -> Denunciar());
        btnSeguir = new Button("Seguir", e -> Seguir());
        topLayout.add(btnSeguir, btnDenunciar);
    }

    /* Usa el parámetro url */
    @Override
    public void setParameter(BeforeEvent event, String parameter) {

        super.setParameter(event, parameter);

        /* recupera el usuario logueado */
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            Youtuber youtuber = (Youtuber) auth.getPrincipal();

            btnSeguir.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            btnDenunciar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            if (_usuario.getSeguido_por().contains(youtuber)) {
                btnSeguir.setText("Dejar de seguir");
            } else {
                btnSeguir.setText("Seguir");
            }
            if (_usuario.getDenunciado_por().contains(youtuber)) {
                btnDenunciar.setText("Quitar denuncia");
            } else {
                btnDenunciar.setText("Denunciar");
            }
            if (_usuario.getLogin().equals(youtuber.getLogin())) {
                btnSeguir.setVisible(false);
                btnDenunciar.setVisible(false);
            }
        }

    }

    public void Seguir() {
        if (btnSeguir.getText().equals("Seguir")) {
            _iYoutuber.seguirUsuario(_usuario.getORMID());
            btnSeguir.setText("Dejar de seguir"); // Cambiar el texto del botón

        } else {
            _iYoutuber.dejardeseguirUsuario(_usuario.getORMID());
            btnSeguir.setText("Seguir"); // Cambiar el texto del botón

        }

    }

    public void Denunciar() {
        if (btnDenunciar.getText().equals("Denunciar")) {
            _iYoutuber.denunciarUsuario(_usuario.getORMID());
            btnDenunciar.setText("Quitar denuncia"); // Cambiar el texto del botón
        } else {
            _iYoutuber.quitardenunciaUsuario(_usuario.getORMID());
            btnDenunciar.setText("Denunciar"); // Cambiar el texto del botón
        }

    }

}