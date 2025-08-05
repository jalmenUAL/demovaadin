package com.example.demo.views;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Minus.Horizontal;

@Route("Perfil")
public class Perfil extends VerticalLayout {

    public Videosgustados _videosgustados;
    public Videospublicados _videospublicados;
    HorizontalLayout topLayout = new HorizontalLayout();
 

     

    public Perfil() {
        setSizeFull();
        setSpacing(true);
        setPadding(false);
        setAlignItems(Alignment.CENTER);

        // Imagen de fondo (cabecera)
        Image imagenDeFondo = new Image("https://picsum.photos/1200/300", "Imagen de fondo");
        imagenDeFondo.setWidth("100%");
        imagenDeFondo.setHeight("300px");
        imagenDeFondo.getStyle().set("object-fit", "cover");

        add(imagenDeFondo);

        // Datos de ejemplo
        String nombreUsuario = "Youtuber Ejemplo";
        String avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg";

        // Título debajo del fondo
        H2 titulo = new H2("Perfil del Youtuber");
        titulo.getStyle().set("color", "#2c3e50").set("margin-top", "10px");
        add(titulo);

        // Avatar y nombre
        Avatar avatar = new Avatar(nombreUsuario, avatarUrl);
        avatar.setWidth("100px");
        avatar.setHeight("100px");

        Span nombreSpan = new Span(nombreUsuario);
        nombreSpan.getStyle()
            .set("font-weight", "bold")
            .set("font-size", "1.3em")
            .set("margin-left", "10px");

        // Botón para ver youtubers seguidos
        Button btnYoutubersSeguidos = new Button("Ver Youtubers Seguidos", new Icon(VaadinIcon.USER_HEART));
        btnYoutubersSeguidos.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnYoutubersSeguidos.getStyle()
            .set("border-radius", "8px")
            .set("font-weight", "bold")
            .set("padding", "8px 16px");

        btnYoutubersSeguidos.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(Youtubersseguidos.class));
        });

        // Layout superior con avatar, nombre y botón
        topLayout.add(avatar, nombreSpan, btnYoutubersSeguidos);
        topLayout.setAlignItems(Alignment.CENTER);
        topLayout.setSpacing(true);
        topLayout.setPadding(true);
        add(topLayout);

        // Inicializar vistas de videos
        _videosgustados = new Videosgustados();
        _videospublicados = new Videospublicados();

        // Layouts para secciones
        VerticalLayout publicadosLayout = new VerticalLayout();
        publicadosLayout.setWidth("45%");
        Span publicadosTitulo = new Span("🎬 Videos Publicados");
        publicadosTitulo.getStyle().set("font-weight", "bold").set("font-size", "1.1em");
        publicadosLayout.add(publicadosTitulo, _videospublicados);

        VerticalLayout gustadosLayout = new VerticalLayout();
        gustadosLayout.setWidth("45%");
        Span gustadosTitulo = new Span("❤️ Videos Gustados");
        gustadosTitulo.getStyle().set("font-weight", "bold").set("font-size", "1.1em");
        gustadosLayout.add(gustadosTitulo, _videosgustados);

        // Layout horizontal para ambas listas
        HorizontalLayout listasLayout = new HorizontalLayout(publicadosLayout, gustadosLayout);
        listasLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        listasLayout.setSpacing(true);
        listasLayout.setWidthFull();

        add(listasLayout);
    }

    }