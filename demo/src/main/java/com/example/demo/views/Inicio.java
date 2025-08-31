package com.example.demo.views;

import com.example.demo.service.iInicio;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("Inicio")
@AnonymousAllowed

public abstract class Inicio extends VerticalLayout {
    public iInicio _iInicio;
    public Buscar _buscar;
    public UltimosVideos _ultimosVideos;

    /* header y body */
    public HorizontalLayout header = new HorizontalLayout();
    public VerticalLayout body = new VerticalLayout();

    /* Accede a la base de datos a través de iInicio */

    public Inicio(iInicio iInicio) {
        this._iInicio = iInicio;

        // Estilos generales del layout
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setAlignItems(Alignment.CENTER);

        // Título principal
        H1 heading = new H1("YouTube");
        heading.getStyle()
                .set("background-color", "#FF0000") // Rojo YouTube
                .set("color", "white")
                .set("padding", "0.5em 1.5em")
                .set("border-radius", "10px")
                .set("font-size", "2.5em")
                .set("box-shadow", "0 4px 8px rgba(0,0,0,0.2)");

        // Header layout con el título centrado
        header.setWidthFull();
        header.setJustifyContentMode(JustifyContentMode.CENTER);
        header.add(heading);

        add(header);
        add(body);

        /* Agrega el componente estático de Buscar */
        Buscar();

    }

    /* Ultimos Videos es dinámico y se llama en el onAttach */
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        UltimosVideos();
    }

    /* Buscar también tiene como parámetro el interfaz */

    public void Buscar() {
        _buscar = new Buscar(_iInicio);
        header.add(_buscar);
        _buscar.botonbuscar.addClickListener(e -> {
            body.removeAll();
            body.add(_buscar._resultadodeBusqueda);
        });
    }

    public abstract void UltimosVideos();

}
