package com.example.demo.views;

import com.example.demo.domain.Comentario;
import com.vaadin.flow.router.Route;

@Route("VerComentariosdeYoutuber_item")

public class VerComentariosdeYoutuber_item extends VerComentarios_item {

    public VerComentariosdeYoutuber_item(Comentario comentario) {
        super(comentario);
         
    }
}