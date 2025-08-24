package com.example.demo.views;

import java.util.Set;

import com.example.demo.domain.Comentario;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("VerComentariosdeAdministrador")

public class VerComentariosdeAdministrador extends VerComentarios {
    iAdministrador _iAdministrador;

    public VerComentariosdeAdministrador(iAdministrador iAdministrador, Set<Comentario> comentarios, int j) {
        super(comentarios,j);
        this._iAdministrador = iAdministrador;
        removeAll();
         if (comentarios.isEmpty()) {
            // Manejar el caso de no comentarios
            Div noComments = new Div();
            noComments.setText("No hay comentarios disponibles.");
            add(noComments);
        }
        else{
        for (Comentario comentario : comentarios) {
            VerComentarios_item comentarioItem = new VerComentariosdeAdministrador_item(_iAdministrador,comentario);
            add(comentarioItem);
        }
    }
    }
 

}