package com.example.demo.views;

 

import com.vaadin.flow.component.textfield.TextField;

import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.button.ButtonVariant;


import com.vaadin.flow.component.html.H2;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("PublicarVideo")

public class PublicarVideo extends VerticalLayout {

    public PerfilPropio _perfilPropio;
    TextField introduzcaLaUrl = new TextField("URL del Video");
    TextField introduzcaEltitulo = new TextField("Título del Video");

    public PublicarVideo(iYoutuber i) {
        setWidthFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSpacing(true);
        setPadding(true);

        // Título
        H2 titulo = new H2("📹 Publicar nuevo video");
        titulo.getStyle().set("color", "#2c3e50");
        add(titulo);

        // Campos de texto
        introduzcaEltitulo.setPlaceholder("Ej. Cómo cocinar arroz");
        introduzcaLaUrl.setPlaceholder("Ej. https://youtube.com/...");
        introduzcaEltitulo.setWidth("60%");
        introduzcaLaUrl.setWidth("60%");

        add(introduzcaEltitulo, introduzcaLaUrl);

        // Botón
        Button button = new Button("Publicar Video");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.getStyle()
            .set("border-radius", "8px")
            .set("font-weight", "bold")
            .set("margin-top", "10px");

        button.addClickListener(e -> {
            
            UI.getCurrent().getPage().getHistory().back();
        });

        add(button);
    }
}













