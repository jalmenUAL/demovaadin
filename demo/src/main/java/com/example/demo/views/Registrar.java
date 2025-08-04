package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.router.Route;

import java.io.InputStream;

@Route("Registrar")
public class Registrar extends VerticalLayout{
    public NoLogueado _noLogueado;
    public ServidordeCorreo _servidordeCorreo;

    private com.vaadin.flow.component.textfield.EmailField login;
    private TextField password;
    private Image avatar;
    private Image imagenDeFondo;

    public void EnviarCorreo() {
        throw new UnsupportedOperationException();
    }

    public Registrar() {
        // Layout para login y password
        VerticalLayout datosLayout = new VerticalLayout();
        login = new com.vaadin.flow.component.textfield.EmailField("Login");
        password = new TextField("Password");
        datosLayout.add(login, password);

        // Layout para avatar
        VerticalLayout avatarLayout = new VerticalLayout();
        Label avatarLabel = new Label("Avatar");
        avatar = new Image();
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
        imagenDeFondo = new Image();
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

        Button registrar = new Button("Registrar");
        registrar.addClickListener(event -> {
            String loginValue = login.getValue();
            String passwordValue = password.getValue();
            String avatarUrl = avatar.getSrc();
            String fondoUrl = imagenDeFondo.getSrc();
            registrar(loginValue, passwordValue, avatarUrl, fondoUrl);
        });
        add(registrar);
    }

    private void registrar(String login, String password, String avatarUrl, String fondoUrl) {
        // Aquí puedes implementar la lógica para registrar el usuario
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Avatar URL: " + avatarUrl);
        System.out.println("Imagen de fondo URL: " + fondoUrl);
        // Lógica para enviar los datos a donde
	}
}