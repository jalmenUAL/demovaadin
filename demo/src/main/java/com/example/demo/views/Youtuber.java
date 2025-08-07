package com.example.demo.views;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

//import basededatos.iYoutuber;

@Route("Youtuber")
@RolesAllowed("USER")
public class Youtuber extends Registrado {
    public iYoutuber _iYoutuber;
    public PerfilPropio _perfilPropio;
    public UltimosVideosdeYoutuber _ultimosVideos;
    com.example.demo.domain.Youtuber usuario = (com.example.demo.domain.Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    public Youtuber(iYoutuber youtuber) {
        super(youtuber);
        _iYoutuber = youtuber;
       

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
        UltimosVideos();
        // Opcional: No añadas directamente PerfilPropio aquí si es una página separada
    }

    public void PerfilPropio() {

        _perfilPropio = new PerfilPropio(_iYoutuber, usuario);
        add(_perfilPropio);
    }

    public void UltimosVideos() {
        List<Video> videos = _iYoutuber.cargarUltimosVideos(usuario.getLogin()); 
        _ultimosVideos = new UltimosVideosdeYoutuber(videos);
        add(_ultimosVideos);
    }
}
