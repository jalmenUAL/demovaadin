package com.example.demo.views;

import com.example.demo.domain.Youtuber;
import com.example.demo.service.iAdministrador;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.Route;

@Route("PerfilAjenodeAdministrador")
public class PerfilAjenodeAdministrador extends PerfilAjeno {
    private Button btnBloquear;
    private iAdministrador iAdministrador;
     


    public void Bloquear() {
        if (btnBloquear.getText().equals("Bloquear")) 
         {  btnBloquear.setText("Quitar Bloqueo"); 
         iAdministrador.bloquearUsuario(_usuario.getORMID());}
         else {  btnBloquear.setText("Bloquear"); 
         iAdministrador.desbloquearUsuario(_usuario.getORMID());}
        
         

    }

    public PerfilAjenodeAdministrador(iAdministrador iAdministrador) {
        
        this.iAdministrador = iAdministrador;
         

        // Crear botón de bloquear usuario
        btnBloquear = new Button("", e -> Bloquear());
        btnBloquear.addThemeVariants(ButtonVariant.LUMO_ERROR); // Botón rojo
       
        // Buscar el layout de botones en la vista padre y añadir el nuevo botón
        // Suponiendo que el layout de botones es el primer HorizontalLayout
         topLayout.add(btnBloquear);


    }

    @Override
public void setParameter(BeforeEvent event, String parameter) {
    // 👇 ejecuta la lógica de la clase padre
    super.setParameter(event, parameter);
    if (_usuario.getBloqueado()) 
         {  btnBloquear.setText("Quitar bloqueo"); }
         else {  btnBloquear.setText("Bloquear"); }
}

    @Override
    public Youtuber getUsuario(String username) {
       return iAdministrador.findYoutuberById(username);
    }
}