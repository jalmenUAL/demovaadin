package com.example.demo.views;




import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Route("login")
public class Login extends VerticalLayout {

    private final AuthenticationManager authenticationManager;

    public Login(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setTitle("Mi aplicación");
        loginOverlay.setDescription("Inicia sesión con tus credenciales");
        loginOverlay.setOpened(true);

        // 🔹 Listener del formulario de login
        loginOverlay.addLoginListener(event -> {
            try {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                event.getUsername(),
                                event.getPassword()
                        )
                );
                

                // ✅ Si autentica correctamente, guardamos el usuario en sesión
                //VaadinSession.getCurrent().setAttribute(Authentication.class, auth);

                // Redirigir según rol
                if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"))) {
    UI.getCurrent().navigate(com.example.demo.views.Administrador.class);
} else {
    UI.getCurrent().navigate(com.example.demo.views.Youtuber.class);
}

            } catch (AuthenticationException e) {
                Notification.show("Usuario o contraseña incorrectos en login", 3000, Notification.Position.MIDDLE);
            }
        });

        add(loginOverlay);
    }
}
