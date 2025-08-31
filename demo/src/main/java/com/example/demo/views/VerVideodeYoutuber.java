package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

@Route("VerVideodeYoutuber")

public class VerVideodeYoutuber extends VerVideo {

    private iYoutuber iYoutuber;
    Button likeButton;

    Boolean legusta;

    public VerVideodeYoutuber(com.example.demo.service.iYoutuber iYoutuber) {
        super(iYoutuber);
        this.iYoutuber = iYoutuber;

    }

    public void like() {

        if (likeButton.getText().equals("Me Gusta")) {
            likeButton.setText("Quitar Me Gusta");
            iYoutuber.likeVideo(video.getId());
            likeButton.getStyle()
                    .set("background-color", "#0d6efd") // negro
                    .set("color", "white")
                    .set("border-radius", "8px")
                    .set("padding", "10px 20px")
                    .set("font-weight", "bold");

        } else {
            likeButton.setText("Me Gusta");
            iYoutuber.dislikeVideo(video.getId());
            likeButton.getStyle()
                    .set("background-color", "#0d6efd") // azul
                    .set("color", "white")
                    .set("border-radius", "8px")
                    .set("padding", "10px 20px")
                    .set("font-weight", "bold");

        }

    }

    @Override
    public void VerComentarios() {
        _verComentarios = new VerComentariosdeYoutuber(video.getTiene_comentarios(), video.getId());
        comentarios.add(_verComentarios);
    }

    public void setParameter(BeforeEvent event, Long parameter) {
        super.setParameter(event, parameter);
        // Crear botón de Like
        likeButton = new Button("", event2 -> like());
        likeButton.setIcon(new Icon(VaadinIcon.THUMBS_UP));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        com.example.demo.domain.Youtuber usuario = (com.example.demo.domain.Youtuber) auth.getPrincipal();
        
        /* OJO. He tenido que recargar al usuario! */
        usuario = iYoutuber.findYoutuberById(usuario.getLogin());
         
        legusta = usuario.getLe_gusta().stream().anyMatch(v -> ((Video) v).getId() == video.getId());

        if (!legusta) {
            likeButton.setText("Me Gusta");
            likeButton.getStyle()
                    .set("background-color", "#0d6efd") // azul
                    .set("color", "white")
                    .set("border-radius", "8px")
                    .set("padding", "10px 20px")
                    .set("font-weight", "bold");
        } else {
            likeButton.setText("Quitar Me Gusta");
            likeButton.getStyle()
                    .set("background-color", "#0d6efd") // azul
                    .set("color", "white")
                    .set("border-radius", "8px")
                    .set("padding", "10px 20px")
                    .set("font-weight", "bold");
        }

        // Añadir el botón a donde quieras (por ejemplo, debajo del video)
        frame_y_comentarios.add(likeButton);

    }
}