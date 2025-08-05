package com.example.demo.views;

import java.io.InputStream;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.textfield.EmailField;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route("Configuracion")
public class Configuracion extends VerticalLayout{
	public PerfilPropio _perfilPropio;
	
public Configuracion() {
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
        EmailField login = new EmailField("Login");
        TextField password = new TextField("Password");
        datosLayout.add(login, password);

        // Layout para avatar
        VerticalLayout avatarLayout = new VerticalLayout();
        avatarLayout.setAlignItems(Alignment.CENTER);
        Label avatarLabel = new Label("Avatar");
        Image avatar = new Image();
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
        Label fondoLabel = new Label("Imagen de fondo");
        Image imagenDeFondo = new Image();
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
            String loginValue = login.getValue();
            String passwordValue = password.getValue();
            String avatarUrl = avatar.getSrc();
            String fondoUrl = imagenDeFondo.getSrc();
            actualizar(loginValue, passwordValue, avatarUrl, fondoUrl);
        });

        // Layout final
        VerticalLayout contenido = new VerticalLayout(datosLayout, imagenesLayout, actualizar);
        contenido.setAlignItems(Alignment.CENTER);
        contenido.setSpacing(true);
        contenido.setPadding(true);

        add(contenido);
    }

// ...existing code...

	private void actualizar(String login, String password, String avatarUrl, String fondoUrl) {
    		// Aquí puedes implementar la lógica para actualizar los datos del usuario

    // Lógica para enviar los datos a donde corresponda
}}
