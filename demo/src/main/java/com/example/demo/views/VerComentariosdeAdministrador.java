package com.example.demo.views;

import java.util.Set;

import com.example.demo.domain.Comentario;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("VerComentariosdeAdministrador")

public class VerComentariosdeAdministrador extends VerComentarios {
    iAdministrador _iAdministrador;

    /* Se añade el iAdministrador porque accede a la base de datos */

    public VerComentariosdeAdministrador(iAdministrador iAdministrador, Set<Comentario> comentarios,int idvideo) {
        super(comentarios,idvideo);
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
            VerComentariosdeAdministrador_item comentarioItem = new VerComentariosdeAdministrador_item(_iAdministrador,comentario);
             comentarioItem.eliminarButton.addClickListener(e->UI.getCurrent().getPage().reload());
            add(comentarioItem);
        }
    }
    }
 

}