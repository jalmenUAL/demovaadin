package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Youtuberseguidos_item")

public class Youtubersseguidos_item extends VerticalLayout{
	public Youtubersseguidos _youtubersseguidos;
	public PerfilAjeno _perfilAjeno;
    com.example.demo.domain.Youtuber youtuber;
public Youtubersseguidos_item(com.example.demo.domain.Youtuber youtuber) {
    this.youtuber = youtuber;
        // Datos de ejemplo (puedes pasarlos por el constructor si deseas)
        String nombreUsuario = youtuber.getLogin();
        int seguidores = youtuber.getSeguido_por().size();
        String avatarUrl = youtuber.getFotoPerfil();

        // Avatar del usuario
        Image avatar = new Image(avatarUrl, "Avatar");
        avatar.setWidth("60px");
        avatar.setHeight("60px");
        avatar.getStyle().set("border-radius", "50%");

        // Nombre de usuario
        Span nombre = new Span(nombreUsuario);
        nombre.getStyle().set("font-weight", "bold").set("font-size", "18px");

        // Número de seguidores
        Span seguidoresLabel = new Span(seguidores + " seguidores");

        // Botón para ver perfil ajeno
        Button verPerfilButton = new Button("Ver perfil", e -> PerfilAjeno());
        verPerfilButton.getStyle()
            .set("background-color", "#0d6efd")
            .set("color", "white")
            .set("border-radius", "8px")
            .set("font-weight", "bold");

        // Layout vertical para los datos del usuario
        VerticalLayout info = new VerticalLayout(nombre, seguidoresLabel, verPerfilButton);
        info.setPadding(false);
        info.setSpacing(false);

        // Layout horizontal: avatar + info
        HorizontalLayout fila = new HorizontalLayout(avatar, info);
        fila.setAlignItems(Alignment.CENTER);
        fila.setSpacing(true);
        fila.setWidthFull();

        // Añadir al layout principal
        add(fila);

        // Opcional: estilo del componente
        getStyle().set("padding", "10px").set("border", "1px solid #ddd").set("border-radius", "10px");
    }

    public void PerfilAjeno() {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
           
            boolean esAdmin = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"));
            boolean esYoutuber = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_YOUTUBER"));
        

        if (esAdmin) {
            UI.getCurrent().navigate(PerfilAjenodeAdministrador.class, youtuber.getLogin());
        } else if (esYoutuber) {
            UI.getCurrent().navigate(PerfilAjenodeYoutuber.class, youtuber.getLogin());
        } else {
            UI.getCurrent().navigate(PerfilAjeno.class, youtuber.getLogin());
        }
    }
    }
}