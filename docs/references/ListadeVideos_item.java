package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("ListadeVideos_item")
public class ListadeVideos_item extends VerticalLayout {
    public ListadeVideos _listadeVideos;
    public VerVideo _verVideo;

    Video video;

    /* Tiene como parámetro el objeto que muestra */

    public ListadeVideos_item(Video video) {
        this.video = video;

        /* Rellena los componentes gráficos con los datos del objeto */
        String tituloVideo = video.getTitulo();
        String propietarioNombre = video.getEs_de().getLogin();
        String propietarioFotoUrl = video.getEs_de().getFotoPerfil();
        int numMeGustas = video.getLe_gusta_a().size();
        int numComentarios = video.getTiene_comentarios().size();

        // Título del video
        Span tituloSpan = new Span(tituloVideo);
        tituloSpan.getStyle().set("font-weight", "bold").set("font-size", "1.2em");

        // Avatar del propietario
        Avatar propietarioAvatar = new Avatar(propietarioNombre, propietarioFotoUrl);

        // Layout horizontal para avatar y título
        HorizontalLayout infoLayout = new HorizontalLayout(propietarioAvatar, tituloSpan);
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.setSpacing(true);
        add(infoLayout);

        // Estadísticas de me gustas y comentarios
        Span meGustasSpan = new Span("👍 " + numMeGustas);
        Span comentariosSpan = new Span("💬 " + numComentarios);
        HorizontalLayout statsLayout = new HorizontalLayout(meGustasSpan, comentariosSpan);
        statsLayout.setSpacing(true);
        add(statsLayout);

        String videoId = video.getUrl().substring(video.getUrl().lastIndexOf("/") + 1);
        if (videoId.contains("?")) {
            videoId = videoId.substring(0, videoId.indexOf("?"));
        }
        if (videoId.contains("#")) {
            videoId = videoId.substring(0, videoId.indexOf("#"));
        }
        String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";

        // Imagen del thumbnail en vez de iframe
        Image thumbnail = new Image(thumbnailUrl, "Miniatura del video");
        thumbnail.setWidth("100%");
        thumbnail.getStyle().set("border-radius", "8px").set("cursor", "pointer");

        /* Event que muestra el video */
        thumbnail.addClickListener(e -> VerVideo());

        add(thumbnail);

    }

    /* Ver video es el mismo para todos los usuarios pero cada uno es distinto */
    public void VerVideo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {

            boolean esAdmin = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"));
            boolean esYoutuber = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_YOUTUBER"));

            if (esAdmin) {
                UI.getCurrent().navigate(VerVideodeAdministrador.class, video.getId());
            } else if (esYoutuber) {
                UI.getCurrent().navigate(VerVideodeYoutuber.class, video.getId());
            }
        } else {
            UI.getCurrent().navigate(VerVideo.class, video.getId());
        }
    }
}
