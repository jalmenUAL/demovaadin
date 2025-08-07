package com.example.demo.views;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.Comentario;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.router.Route;

@Route("VerComentariosdeAdministrador")

public class VerComentariosdeAdministrador extends VerComentarios {

    public VerComentariosdeAdministrador(iAdministrador iAdministrador,Set<Comentario> comentarios) {
        super(comentarios);
        removeAll();
        for (Comentario comentario : comentarios) {
            VerComentarios_item comentarioItem = new VerComentariosdeAdministrador_item(iAdministrador,comentario);
            add(comentarioItem);
        }
    }
 

}