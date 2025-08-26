package com.example.demo.views;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

@Route("VerVideodeYoutuber")

public class VerVideodeYoutuber extends VerVideo {

    private iYoutuber iYoutuber;
    Button likeButton;
    Button dislikeButton;
    public VerVideodeYoutuber(com.example.demo.service.iYoutuber iYoutuber) {
        super(iYoutuber);
        this.iYoutuber = iYoutuber;

       
         
    }
 

    public void like() {
         
             iYoutuber.likeVideo(video.getId());
             Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
            String username = auth.getName();
            com.example.demo.domain.Youtuber usuario = iYoutuber.findYoutuberById(username);

             Set<Video> vl = usuario.getLe_gusta();
            Boolean legusta = false;

            for (Video v:vl){
                if (v.getId()==video.getId())
            {legusta = true;}
            }
              if (!legusta) {
                 
                likeButton.getStyle()
            .set("background-color", "black") // negro
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

               

            }  else
            {
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
            _verComentarios = new VerComentariosdeYoutuber( iYoutuber, video.getTiene_comentarios(),video.getId());
        comentarios.add(_verComentarios);
    }

    public void setParameter(BeforeEvent event, Long parameter) {
         super.setParameter(event,parameter);
         // Crear botón de Like
        likeButton = new Button("Me Gusta", event2 -> like());
        likeButton.setIcon(new Icon(VaadinIcon.THUMBS_UP));
         
        

        // Estilizar el botón (opcional)
        likeButton.getStyle()
            .set("background-color", "#0d6efd") // azul
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

       

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
            String username = auth.getName();
            com.example.demo.domain.Youtuber usuario = iYoutuber.findYoutuberById(username);
            Set<Video> vl = usuario.getLe_gusta();
            Boolean legusta = false;

            for (Video v:vl){
                if (v.getId()==video.getId())
            {legusta = true;}
            }
            

            if (!legusta) {
                 
                likeButton.getStyle()
            .set("background-color", "black") // azul
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");
            }  else
            {
                likeButton.getStyle()
            .set("background-color", "#0d6efd") // azul
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");
            }

        // Añadir el botón a donde quieras (por ejemplo, debajo del video)
        frame_y_comentarios.add(likeButton);
          
       

}}