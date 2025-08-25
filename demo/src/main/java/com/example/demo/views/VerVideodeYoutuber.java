package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

@Route("VerVideodeYoutuber")

public class VerVideodeYoutuber extends VerVideo {

    private iYoutuber iYoutuber;
    Button likeButton;
    public VerVideodeYoutuber(com.example.demo.service.iYoutuber iYoutuber) {
        super(iYoutuber);
        this.iYoutuber = iYoutuber;

       
         
    }
 

    public void like() {
        if (likeButton.isEnabled()) {
            likeButton.setEnabled(false);
             iYoutuber.likeVideo(video.getId());
             Notification.show("Has dado like a este video.");
            
        } else{
            likeButton.setEnabled(true); 
            iYoutuber.likeVideo(video.getId());
            Notification.show("Has quitado el like a este video.");
        }

    }
 
    @Override
    public void VerComentarios() {
            _verComentarios = new VerComentariosdeYoutuber( iYoutuber, video.getTiene_comentarios(),video.getId());
        comentarios.add(_verComentarios);
    }

    public void setParameter(BeforeEvent event, Long parameter) {
         super.setParameter(event,parameter);
         // Crear botón de Like
        likeButton = new Button("👍 Me gusta", event2 -> like());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
            String username = auth.getName();
            com.example.demo.domain.Youtuber usuario = iYoutuber.findYoutuberById(username);
            if (usuario.getLe_gusta().contains(video)) {
                likeButton.setEnabled(false);
            } else {
                likeButton.setEnabled(true);
            }

        // Estilizar el botón (opcional)
        likeButton.getStyle()
            .set("background-color", "#0d6efd") // azul
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

        // Añadir el botón a donde quieras (por ejemplo, debajo del video)
        frame_y_comentarios.add(likeButton);
       

}}