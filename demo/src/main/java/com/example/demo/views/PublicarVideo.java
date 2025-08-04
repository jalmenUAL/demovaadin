package com.example.demo.views;

import com.vaadin.flow.component.combobox.ComboBox;

import com.vaadin.flow.component.listbox.ListBox;

import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import com.vaadin.flow.component.textfield.TextField;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.example.demo.domain.Video;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.button.ButtonVariant;

import com.vaadin.flow.component.html.Span;

import com.vaadin.flow.component.html.Paragraph;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("PublicarVideo")

public class PublicarVideo extends VerticalLayout{
	public PerfilPropio _perfilPropio;
	TextField introduzcaLaUrl = new TextField("Introduzca la url");
	TextField introduzcaEltitulo = new TextField("Introduzca el título");
	public  PublicarVideo(iYoutuber i) {

    Button button = new Button("Publicar Video");
    button.addThemeVariants(ButtonVariant.LUMO_PRIMARY); // Botón azul
    button.addClickListener(e -> {
        UI.getCurrent().getPage().getHistory().back();
        i.publicar(introduzcaEltitulo.getValue(), introduzcaLaUrl.getValue());
    });

    getStyle().setWidth("100%");

    introduzcaLaUrl.setWidth("100%");
    add(introduzcaLaUrl);

    introduzcaEltitulo.setWidth("100%");
    add(introduzcaEltitulo);

    add(button);
	}
}














