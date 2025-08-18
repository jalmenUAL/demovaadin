package com.example.demo.views;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioComentario;
import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.service.BDPrincipal;
import com.example.demo.service.BD_Administradores;
import com.example.demo.service.BD_Comentarios;
import com.example.demo.service.BD_Videos;
import com.example.demo.service.BD_Youtubers;
import com.example.demo.service.iRegistrado;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;

import jakarta.annotation.security.RolesAllowed;


@Route("Registrado")
@Component
@UIScope  // importante

public class Registrado extends Inicio {
    public iRegistrado _iRegistrado;

    public Registrado(BD_Videos videos, BD_Comentarios comentarios, BD_Youtubers youtubers, BD_Administradores administradores) {
        super(videos, comentarios, youtubers, administradores);
        // Inicializa el servicio iRegistrado con la base de datos principal
		_iRegistrado = new BDPrincipal(videos, comentarios, youtubers, administradores);


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
        new SecurityContextLogoutHandler().logout(
        VaadinServletRequest.getCurrent().getHttpServletRequest(),
        null,
        null);
        VaadinSession.getCurrent().close();
        VaadinSession.getCurrent().setAttribute("Registrado", null);

        getUI().ifPresent(ui -> ui.navigate("NoLogueado"));
    }

     

}