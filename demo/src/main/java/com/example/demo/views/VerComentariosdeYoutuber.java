package com.example.demo.views;

import java.util.Set;

import com.example.demo.domain.Comentario;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.example.demo.service.iYoutuber;


@Route("VerComentariosdeYoutuber")
public class VerComentariosdeYoutuber extends VerComentarios {

    private iYoutuber iYoutuber;
    private String id;

    public VerComentariosdeYoutuber(iYoutuber iYoutuber, Set<Comentario> comentarios, int j) {
        super(comentarios,j);
        this.iYoutuber = iYoutuber;
        this.id = Integer.toString(j);


        removeAll();
        // Crear botón "Comentar"
        Button comentarButton = new Button("Comentar", event -> comentar());

        // Estilo del botón
        comentarButton.getStyle()
            .set("background-color", "#28a745") // verde
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

        // Layout para centrar el botón
        HorizontalLayout centrarLayout = new HorizontalLayout(comentarButton);
        centrarLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centrarLayout.setWidthFull();

        // Agregar botón a la vista
        add(centrarLayout);

        
         if (comentarios.isEmpty()) {
            // Manejar el caso de no comentarios
            Div noComments = new Div();
            noComments.setText("No hay comentarios disponibles.");
            add(noComments);
        }
        else{
        for (Comentario comentario : comentarios) {
            VerComentarios_item comentarioItem = new VerComentariosdeYoutuber_item(comentario);
            add(comentarioItem);
        }
    }
    }

    public void comentar() {
       UI.getCurrent().navigate(Comentar.class,id);
        
         
    }
}