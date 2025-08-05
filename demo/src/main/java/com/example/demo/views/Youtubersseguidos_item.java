package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Youtuberseguidos_item")

public class Youtubersseguidos_item extends VerticalLayout{
	public Youtubersseguidos _youtubersseguidos;
	public PerfilAjeno _perfilAjeno;
public Youtubersseguidos_item() {
        // Datos de ejemplo (puedes pasarlos por el constructor si deseas)
        String nombreUsuario = "CanalGenial";
        int seguidores = 25400;
        String avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg"; // Reemplaza por URL real

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
        Notification.show("Abrir perfil ajeno (no implementado aún)", 3000, Notification.Position.MIDDLE);
        // Aquí podrías navegar a otra vista o abrir un componente
        // UI.getCurrent().navigate("perfil-ajeno");
    }
}