package com.example.demo.views;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.BD_Administradores;
import com.example.demo.service.BD_Comentarios;
import com.example.demo.service.BD_Videos;
import com.example.demo.service.BD_Youtubers;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iYoutuber;

@Route("Youtuber")
@RolesAllowed("ROLE_YOUTUBER")
 

public class Youtuber extends Registrado {
    public iYoutuber _iYoutuber;
    public PerfilPropio _perfilPropio;
    public UltimosVideosdeYoutuber _ultimosVideos;
    public com.example.demo.domain.Youtuber usuario;

    public Youtuber( BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers, BD_Administradores administradores) {
        super(videos, comentarios, youtubers, administradores);
       //_iYoutuber = new BDPrincipal(videos, comentarios, youtubers, administradores);
        //usuario = (com.example.demo.domain.Youtuber) VaadinSession.getCurrent().getAttribute(com.example.demo.domain.Registrado.class);

        // === HEADER con botón "Mi Perfil" ===
        Button perfilBtn = new Button("Mi Perfil", new Icon(VaadinIcon.USER));
        perfilBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        perfilBtn.getStyle()
            .set("margin", "10px")
            .set("border-radius", "8px");

        perfilBtn.addClickListener(e -> {
            UI.getCurrent().navigate(PerfilPropio.class);
        });

        
        header.setWidthFull();
        header.setJustifyContentMode(JustifyContentMode.END); // alineado a la derecha
        header.setPadding(true);
        header.add(perfilBtn);

        // === CONTENIDO PRINCIPAL ===
        //UltimosVideos();
        // Opcional: No añadas directamente PerfilPropio aquí si es una página separada
    }

    public void PerfilPropio() {
        //_perfilPropio = new PerfilPropio(_iYoutuber, usuario);
        //add(_perfilPropio);
    }

    public void UltimosVideos() {
       //List<Video> videos = _iYoutuber.cargarUltimosVideos(usuario.getLogin()); 
       // _ultimosVideos = new UltimosVideosdeYoutuber(videos);
       // add(_ultimosVideos);
    }
}
