package com.example.demo.views;

import com.vaadin.flow.router.Route;

@Route("VerComentariosdeAdministrador")

public class VerComentariosdeAdministrador extends VerComentarios {

    public VerComentariosdeAdministrador() {
        super();
        removeAll();
        VerComentarios_item vci = new VerComentariosdeAdministrador_item();
		add(vci);
		VerComentarios_item vci2 = new VerComentariosdeAdministrador_item();
		add(vci2);
		VerComentarios_item vci3 = new VerComentariosdeAdministrador_item();
		add(vci3);
    }
 

}