package com.example.demo.views;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

@Route("VerVideodeAdministrador")

public class VerVideodeAdministrador extends VerVideo {

    iAdministrador iAdministrador;

    public VerVideodeAdministrador(iAdministrador iAdministrador) {

        super(iAdministrador);
        this.iAdministrador = iAdministrador;
        
    }

 

    public void borrar() {
         
       iAdministrador.borrarVideo(video.getId());
         UI.getCurrent().getPage().getHistory().back();
       
    }

     public void setParameter(BeforeEvent event, Long parameter) {
         super.setParameter(event,parameter);
         // Crear botón de borrar
        Button borrarButton = new Button("🗑️ Borrar video", event2 -> borrar());

        // Estilo opcional
        borrarButton.getStyle()
            .set("background-color", "#dc3545") // rojo
            .set("color", "white")
            .set("border-radius", "8px")
            .set("padding", "10px 20px")
            .set("font-weight", "bold");

        // Añadir al layout del video (por ejemplo debajo del iframe)
        frame_y_comentarios.add(borrarButton);
     
    }

 


 




    @Override
    public void VerComentarios() {

            _verComentarios = new VerComentariosdeAdministrador( iAdministrador, video.getTiene_comentarios(),video.getId());
        comentarios.add(_verComentarios);
 
    }
		
    	
}