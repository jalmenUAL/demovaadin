package com.example.demo.views;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("Perfil")
public class Perfil extends VerticalLayout{
    public Videosgustados _videosgustados;
    public Videospublicados _videospublicados;
    public Youtubersseguidos _youtubersseguidos;

    public void Videosgustados() {
        throw new UnsupportedOperationException();
    }

    public void Videospublicados() {
        throw new UnsupportedOperationException();
    }

    public void Youtubersseguidos() {
        // Navega a la vista de youtubers seguidos
        getUI().ifPresent(ui -> ui.navigate("Youtuberseguidos"));
    }

    public Perfil() {
        // Datos de ejemplo
        String nombreUsuario = "Usuario Ejemplo";
        String avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg";

        // Avatar y nombre
        Avatar avatar = new Avatar(nombreUsuario, avatarUrl);
        Span nombreSpan = new Span(nombreUsuario);
        nombreSpan.getStyle().set("font-weight", "bold").set("font-size", "1.2em");

        // Botón para navegar a la lista de youtubers seguidos
        Button btnYoutubersSeguidos = new Button("Ver youtubers seguidos", e -> Youtubersseguidos());

        // Layout horizontal para avatar, nombre y botón, centrados verticalmente
        HorizontalLayout avatarBotonLayout = new HorizontalLayout(avatar, nombreSpan, btnYoutubersSeguidos);
        avatarBotonLayout.setAlignItems(HorizontalLayout.Alignment.CENTER);
        add(avatarBotonLayout);

        // Listas de videos con títulos
        _videosgustados = new Videosgustados();
        _videospublicados = new Videospublicados();

        VerticalLayout publicadosLayout = new VerticalLayout();
        Span publicadosTitulo = new Span("Videos Publicados");
        publicadosTitulo.getStyle().set("font-weight", "bold");
        publicadosLayout.add(publicadosTitulo, _videospublicados);

        VerticalLayout gustadosLayout = new VerticalLayout();
        Span gustadosTitulo = new Span("Videos Gustados");
        gustadosTitulo.getStyle().set("font-weight", "bold");
        gustadosLayout.add(gustadosTitulo, _videosgustados);

        // Layout horizontal para las listas
        HorizontalLayout listasLayout = new HorizontalLayout(publicadosLayout, gustadosLayout);
        add(listasLayout);
    }
}