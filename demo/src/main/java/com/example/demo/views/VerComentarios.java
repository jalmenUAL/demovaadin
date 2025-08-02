package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("VerComentarios")

public class VerComentarios extends VerticalLayout{
	public VerVideo _verVideo;
	public Vector<VerComentarios_item> _item = new Vector<VerComentarios_item>();
	
	public VerComentarios() {
		
		VerComentarios_item vci = new VerComentarios_item();
		add(vci);
		VerComentarios_item vci2 = new VerComentarios_item();
		add(vci2);
		VerComentarios_item vci3 = new VerComentarios_item();
		add(vci3);
	}
}