package com.example.demo.views;


import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Videosrelacionados")

public class Videosrelacionados extends VerticalLayout{
	public VerVideo _verVideo;
	public Vector<Videosrelacionados_item> _item = new Vector<Videosrelacionados_item>();
public Videosrelacionados() {
	
	Videosrelacionados_item vri = new Videosrelacionados_item();
	add(vri);
	Videosrelacionados_item vri2 = new Videosrelacionados_item();
	add(vri2);
	Videosrelacionados_item vri3 = new Videosrelacionados_item();
	add(vri3);
	Videosrelacionados_item vri4 = new Videosrelacionados_item();
	add(vri4);
	Videosrelacionados_item vri5 = new Videosrelacionados_item();
	add(vri5);
	Videosrelacionados_item vri6 = new Videosrelacionados_item();
	add(vri6);
	getStyle().set("width", "100%");
    
}
}
