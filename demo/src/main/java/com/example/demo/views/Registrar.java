package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
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
        // Estilo general centrado
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSpacing(true);

        // Cabecera estilizada
        H1 cabecera = new H1("Crear nueva cuenta");
        cabecera.getStyle().set("color", "#2c3e50");
        add(cabecera);

        // Layout para login y password
        VerticalLayout datosLayout = new VerticalLayout();
        datosLayout.setAlignItems(Alignment.CENTER);
        login = new EmailField("Login");
        password = new TextField("Password");
        datosLayout.add(login, password);

        // Layout para avatar
        VerticalLayout avatarLayout = new VerticalLayout();
        avatarLayout.setAlignItems(Alignment.CENTER);
        Label avatarLabel = new Label("Avatar");
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
        Label fondoLabel = new Label("Imagen de fondo");
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

        // Layout horizontal para imágenes
        HorizontalLayout imagenesLayout = new HorizontalLayout(avatarLayout, fondoLayout);
        imagenesLayout.setAlignItems(Alignment.START);
        imagenesLayout.setSpacing(true);

        // Botón de registrar con icono y color
        Button registrar = new Button("Registrar", new Icon(VaadinIcon.USER_CHECK));
        registrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        registrar.addClickListener(event -> {
            String loginValue = login.getValue();
            String passwordValue = password.getValue();
            String avatarUrl = avatar.getSrc();
            String fondoUrl = imagenDeFondo.getSrc();
            registrar(loginValue, passwordValue, avatarUrl, fondoUrl);
        });

        // Layout final agrupado
        VerticalLayout contenido = new VerticalLayout(datosLayout, imagenesLayout, registrar);
        contenido.setAlignItems(Alignment.CENTER);
        contenido.setSpacing(true);
        contenido.setPadding(true);

        add(contenido);
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