package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Youtuberseguidos")

public class Youtubersseguidos extends VerticalLayout {
	public Perfil _perfil;
	public Vector<Youtubersseguidos_item> _item = new Vector<Youtubersseguidos_item>();
}