package com.example.demo.views;

import java.util.List;

import org.springframework.security.core.Authentication;
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
@RolesAllowed("ROLE_YOUTUBER")

public class Youtuber extends Registrado {
    public iYoutuber _iYoutuber;
    public PerfilPropio _perfilPropio;
    public UltimosVideosdeYoutuber _ultimosVideos;
    public com.example.demo.domain.Youtuber usuario;
    String username;

    public Youtuber(iYoutuber iYoutuber) {
        super(iYoutuber);

        _iYoutuber = iYoutuber;

        // === HEADER con botón "Mi Perfil" ===
        Button perfilBtn = new Button("Mi Perfil", new Icon(VaadinIcon.USER));
        perfilBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        perfilBtn.getStyle()
                .set("margin", "10px")
                .set("border-radius", "8px");

        perfilBtn.addClickListener(e -> {
            PerfilPropio();

        });

        header.setWidthFull();
        header.setJustifyContentMode(JustifyContentMode.END); // alineado a la derecha
        header.setPadding(true);
        header.add(perfilBtn);

    }

    public void PerfilPropio() {
        UI.getCurrent().navigate(PerfilPropio.class, username);
    }

    @Override
    public void UltimosVideos() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        usuario = _iYoutuber.findYoutuberById(username);
        List<Video> videos = _iYoutuber.getYoutuberVideos(usuario.getLogin());
        _ultimosVideos = new UltimosVideosdeYoutuber(videos);
        body.add(_ultimosVideos);
    }

}
