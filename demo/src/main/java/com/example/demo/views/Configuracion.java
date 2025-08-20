package com.example.demo.views;

import java.io.InputStream;

import com.example.demo.service.iYoutuber;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.textfield.EmailField;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import jakarta.annotation.security.RolesAllowed;

@Route("Configuracion")
@RolesAllowed("ROLE_YOUTUBER")  
public class Configuracion extends VerticalLayout{
	public PerfilPropio _perfilPropio;
    private iYoutuber _iYoutuber;
      
    private Image imagenDeFondo;
    private Image avatar;
    private TextField password;
	
public Configuracion(iYoutuber iYoutuber) {
    _iYoutuber = iYoutuber;
        // Estilo general centrado
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSpacing(true);

        // Cabecera
        H1 heading = new H1("Configuración");
        heading.getStyle().set("color", "#2c3e50");
        add(heading);

        // Layout para login y password
        VerticalLayout datosLayout = new VerticalLayout();
        datosLayout.setAlignItems(Alignment.CENTER);
        
         password = new TextField("New Password");
        datosLayout.add( password);

        // Layout para avatar
        VerticalLayout avatarLayout = new VerticalLayout();
        avatarLayout.setAlignItems(Alignment.CENTER);
        Span avatarLabel = new Span("Avatar");
         avatar = new Image();
        avatar.setMaxWidth("300px");
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
        upload.addSucceededListener(event -> {
            InputStream inputStream = buffer.getInputStream();
            StreamResource resource = new StreamResource(event.getFileName(), () -> inputStream);
            avatar.setSrc(resource);
        });
        avatarLayout.add(avatarLabel, upload, avatar);

        // Layout para imagen de fondo
        VerticalLayout fondoLayout = new VerticalLayout();
        fondoLayout.setAlignItems(Alignment.CENTER);
       Span fondoLabel = new Span("Imagen de fondo");
         imagenDeFondo = new Image();
        imagenDeFondo.setMaxWidth("300px");
        MemoryBuffer buffer2 = new MemoryBuffer();
        Upload upload2 = new Upload(buffer2);
        upload2.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
        upload2.addSucceededListener(event -> {
            InputStream inputStream = buffer2.getInputStream();
            StreamResource resource = new StreamResource(event.getFileName(), () -> inputStream);
            imagenDeFondo.setSrc(resource);
        });
        fondoLayout.add(fondoLabel, upload2, imagenDeFondo);

        // Layout horizontal para las imágenes
        HorizontalLayout imagenesLayout = new HorizontalLayout(avatarLayout, fondoLayout);
        imagenesLayout.setAlignItems(Alignment.START);
        imagenesLayout.setSpacing(true);

        // Botón actualizar estilizado con icono
        Button actualizar = new Button("Actualizar", new Icon(VaadinIcon.REFRESH));
        actualizar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        actualizar.addClickListener(event -> {
             
            actualizar(_iYoutuber);
        });

        // Layout final
        VerticalLayout contenido = new VerticalLayout(datosLayout, imagenesLayout, actualizar);
        contenido.setAlignItems(Alignment.CENTER);
        contenido.setSpacing(true);
        contenido.setPadding(true);

        add(contenido);
    }

// ...existing code...

	private void actualizar(iYoutuber iYoutuber) {
        iYoutuber.actualizarConfiguracion(
            
            password.getValue(),
            avatar.getSrc(),
            imagenDeFondo.getSrc()
        );
    		UI.getCurrent().getPage().getHistory().back();

    // Lógica para enviar los datos a donde corresponda
}
}