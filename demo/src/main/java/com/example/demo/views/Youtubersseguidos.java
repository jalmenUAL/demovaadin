package com.example.demo.views;

import java.util.Vector;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@Route("Youtuberseguidos")
@RolesAllowed("ROLE_YOUTUBER")

public class Youtubersseguidos extends VerticalLayout {
	public Perfil _perfil;
	public Vector<Youtubersseguidos_item> _item = new Vector<Youtubersseguidos_item>();

	public Youtubersseguidos() {
		// --- 0. Configuración inicial del layout ---
		setPadding(true); // Añadir padding para que no esté pegado al borde
		setSpacing(true); // Añadir espacio entre los componentes

		// --- 1. Título de la vista ---
		H1 titulo = new H1("Youtubers Seguidos");
		titulo.getStyle().set("text-align", "center");
		add(titulo);

	// --- 1. Crear el contenedor del Grid ---
        // Usamos FlexLayout para crear un grid que se ajusta automáticamente.
        FlexLayout gridContainer = new FlexLayout();
        
        // Queremos que los items pasen a la siguiente línea si no caben.
        gridContainer.setFlexWrap(FlexLayout.FlexWrap.WRAP); 
        
        // Añadimos un poco de espacio entre los items.
        gridContainer.getStyle().set("gap", "1em"); 

        // --- 2. Crear y añadir los 3 items ---
        // En una aplicación real, estos datos vendrían de tu base de datos o de un servicio.
        // Aquí usamos datos de ejemplo.
        for (int i = 1; i <= 3; i++) {
            // Creamos una nueva instancia del item con datos de ejemplo
            Youtubersseguidos_item youtuberItem = new Youtubersseguidos_item(
            );

            // Añadimos el item a nuestro vector de referencias
            this._item.add(youtuberItem);

            // Añadimos el item al contenedor del grid visual
            gridContainer.add(youtuberItem);
        }

        // --- 3. Añadir el grid al layout principal ---
        // Finalmente, añadimos nuestro gridContainer (que ya tiene los 3 items)
        // al layout principal de la clase.
        add(gridContainer);
        
        // Opcional: Centrar el grid en la página
        setHorizontalComponentAlignment(Alignment.CENTER, gridContainer);
}
}