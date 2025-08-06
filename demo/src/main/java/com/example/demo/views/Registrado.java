package com.example.demo.views;

import com.example.demo.service.iRegistrado;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

//import basededatos.iRegistrado;

@Route("Registrado")
public class Registrado extends Inicio {

    public Registrado(iRegistrado registrado) {
        super(registrado); // Llama al constructor de Inicio para añadir el buscador
        // Botón de logout
        Button logoutButton = new Button("Cerrar sesión", new Icon(VaadinIcon.SIGN_OUT));
        logoutButton.addThemeVariants(ButtonVariant.LUMO_ERROR); // Estilo rojo
        logoutButton.getStyle()
            .set("margin-left", "auto") // Lo empuja a la derecha
            .set("font-weight", "bold");

        logoutButton.addClickListener(e -> Logout());

        // Asegúrate de que el header esté inicializado y se use un HorizontalLayout
        if (header != null) {
            header.add(logoutButton);
        } else {
            HorizontalLayout headerConLogout = new HorizontalLayout();
            headerConLogout.setWidthFull();
            headerConLogout.setAlignItems(Alignment.CENTER);

            H1 titulo = new H1("Youtube");
            titulo.getStyle()
                .set("color", "white")
                .set("background-color", "red")
                .set("padding", "0.5em 1em")
                .set("border-radius", "8px");

            headerConLogout.add(titulo, logoutButton);
            add(headerConLogout);
        }
    }

    public void Logout() {
        // Aquí va la lógica real para cerrar sesión
        // Por ejemplo: limpiar sesión, redirigir al login...
        getUI().ifPresent(ui -> ui.navigate("NoLogueado"));
    }
}