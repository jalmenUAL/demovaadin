package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("ListadeVideos")
public class ListadeVideos extends VerticalLayout {
	public Vector<ListadeVideos_item> _item = new Vector<ListadeVideos_item>();
}