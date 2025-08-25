package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Youtuber;
import com.example.demo.service.iAdministrador;
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

    public void Denunciar() {
       _iYoutuber.denunciarUsuario(_usuario.getORMID());
        btnDenunciar.setEnabled(false); // Deshabilitar el botón tras la denuncia
        btnDenunciar.setText("Denunciado"); // Cambiar el texto del botón
        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
        
    }

    public void Seguir() {
        _iYoutuber.seguirUsuario(_usuario.getORMID());
        btnSeguir.setEnabled(false); // Deshabilitar el botón tras la denuncia
        btnSeguir.setText("Siguiendo"); // Cambiar el texto del botón
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_CONTRAST); // Cambiar
         
    }

    public PerfilAjenodeYoutuber(iYoutuber iYoutuber) {
       
        this._iYoutuber = iYoutuber;

        // Crear botones de denunciar y seguir
        btnDenunciar = new Button("Denunciar", e -> Denunciar());
        btnSeguir = new Button("Seguir", e -> Seguir());
       
       

        btnDenunciar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        btnSeguir.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        
        

        topLayout.add(btnSeguir,btnDenunciar);
    }
@Override
public void setParameter(BeforeEvent event, String parameter) {
    // 👇 ejecuta la lógica de la clase padre
    super.setParameter(event, parameter);
     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Youtuber youtuber = (Youtuber) auth.getPrincipal();
         if (_usuario.getSeguido_por().contains(youtuber)) {btnSeguir.setEnabled(false);}
        if (_usuario.getDenunciado_por().contains(youtuber)) {btnDenunciar.setEnabled(false);}
         if (_usuario.getLogin().equals(youtuber.getLogin())) {btnSeguir.setVisible(false);btnDenunciar.setVisible(false);}
        
    }


    @Override
    public Youtuber getUsuario(String username) {
       return _iYoutuber.findYoutuberById(username);
    }

 
}