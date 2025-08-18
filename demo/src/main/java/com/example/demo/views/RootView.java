package com.example.demo.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class RootView extends VerticalLayout {
    public RootView() {
        UI.getCurrent().navigate("login");
    }
}
