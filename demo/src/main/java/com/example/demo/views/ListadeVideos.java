package com.example.demo.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.demo.domain.Video;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("ListadeVideos")
public class ListadeVideos extends VerticalLayout {
    public Vector<ListadeVideos_item> _item = new Vector<ListadeVideos_item>();
 

    public ListadeVideos(Set<Video> videos2) {
        int columnas = 2;
        int index = 0;
        List<Video> videos = new ArrayList<>(videos2);
        while (index < videos.size()) {
            HorizontalLayout fila = new HorizontalLayout();
            fila.setWidthFull();
            fila.setSpacing(true);
            fila.getStyle().set("justify-content", "space-between");

            for (int c = 0; c < columnas && index < videos.size(); c++) {
                Video video = videos.get(index);
                ListadeVideos_item item = new ListadeVideos_item(video);
                item.setWidth("48%"); // Para que entren dos en una fila con espacio
                _item.add(item);
                fila.add(item);
                index++;
            }

            add(fila);
        }
    }
}
