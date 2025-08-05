package com.example.demo.views;

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

    public Youtuber() {
        super();

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
        _perfilPropio = new PerfilPropio();
        add(_perfilPropio);
    }

    public void UltimosVideos() {
        _ultimosVideos = new UltimosVideosdeYoutuber();
        add(_ultimosVideos);
    }
}
