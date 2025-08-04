package com.example.demo.views;

import java.io.InputStream;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.textfield.EmailField;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route("Configuracion")
public class Configuracion extends VerticalLayout{
	public PerfilPropio _perfilPropio;
	
	// ...existing code...
public Configuracion() {
    H1 heading1 = new H1("Configuracion");
    add(heading1);

    // Layout para login y password
    VerticalLayout datosLayout = new VerticalLayout();
    EmailField login = new EmailField("Login");
    TextField password = new TextField("Password");
    datosLayout.add(login, password);

    // Layout para avatar
    VerticalLayout avatarLayout = new VerticalLayout();
    Label avatarLabel = new Label("Avatar");
    Image avatar = new Image();
    avatar.setMaxWidth("300px");
    MemoryBuffer buffer = new MemoryBuffer();
    Upload upload = new Upload(buffer);
    upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
    upload.addSucceededListener(event -> {
        InputStream inputStream = buffer.getInputStream();
        StreamResource resource = new StreamResource(
            event.getFileName(),
            () -> inputStream
        );
        avatar.setSrc(resource);
    });
    avatarLayout.add(avatarLabel, upload, avatar);

    // Layout para imagen de fondo
    VerticalLayout fondoLayout = new VerticalLayout();
    Label fondoLabel = new Label("Imagen de fondo");
    Image imagenDeFondo = new Image();
    imagenDeFondo.setMaxWidth("300px");
    MemoryBuffer buffer2 = new MemoryBuffer();
    Upload upload2 = new Upload(buffer2);
    upload2.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
    upload2.addSucceededListener(event -> {
        InputStream inputStream = buffer2.getInputStream();
        StreamResource resource = new StreamResource(
            event.getFileName(),
            () -> inputStream
        );
        imagenDeFondo.setSrc(resource);
    });
    fondoLayout.add(fondoLabel, upload2, imagenDeFondo);

    // Layout horizontal para las imágenes
    HorizontalLayout imagenesLayout = new HorizontalLayout(avatarLayout, fondoLayout);

    // Añadir ambos layouts al principal
    add(datosLayout, imagenesLayout);

    Button actualizar = new Button("Actualizar");
    actualizar.addClickListener(event -> {
        // Recoge los valores actuales de los campos
        String loginValue = login.getValue();
        String passwordValue = password.getValue();
        String avatarUrl = avatar.getSrc();
        String fondoUrl = imagenDeFondo.getSrc();

        // Llama al método con parámetros
        actualizar(loginValue, passwordValue, avatarUrl, fondoUrl);
    });
    add(actualizar);
}
// ...existing code...

	private void actualizar(String login, String password, String avatarUrl, String fondoUrl) {
    		// Aquí puedes implementar la lógica para actualizar los datos del usuario

    // Lógica para enviar los datos a donde corresponda
}}
