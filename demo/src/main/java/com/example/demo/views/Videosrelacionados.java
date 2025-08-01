package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Videosrelacionados")

public class Videosrelacionados extends VerticalLayout{
	public VerVideo _verVideo;
	public Vector<Videosrelacionados_item> _item = new Vector<Videosrelacionados_item>();
}