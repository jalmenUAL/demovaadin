package com.example.demo.views;

import java.util.Set;
import java.util.Vector;

import com.example.demo.service.iInicio;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@Route("Youtuberseguidos")
@RolesAllowed("ROLE_YOUTUBER")

public class Youtubersseguidos extends VerticalLayout  implements HasUrlParameter<String>  {
	public Perfil _perfil;
	public Vector<Youtubersseguidos_item> _item = new Vector<Youtubersseguidos_item>();
     

    Set<com.example.demo.domain.Youtuber> youtubers;

    iInicio _iInicio;


	public Youtubersseguidos(iInicio iInicio) {
        this._iInicio = iInicio;
        
        
         

		// --- 0. Configuración inicial del layout ---
		setPadding(true); // Añadir padding para que no esté pegado al borde
		setSpacing(true); // Añadir espacio entre los componentes

		// --- 1. Título de la vista ---
		H1 titulo = new H1("Youtubers Seguidos");
		titulo.getStyle().set("text-align", "center");
		add(titulo);

	

        
}

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        // Aquí puedes implementar la lógica para manejar el parámetro de la URL
        // Por ejemplo, podrías buscar el usuario correspondiente al nombre de usuario
        // proporcionado en el parámetro y luego cargar su información en la vista.
        youtubers = _iInicio.getYoutubersSeguidos(parameter);
        // --- 2. Crear y añadir los 3 items ---
        // En una aplicación real, estos datos vendrían de tu base de datos o de un servicio.
        // Aquí usamos datos de ejemplo.
        if (youtubers == null) {
        	  
        }
        else  {

            // --- 1. Crear el contenedor del Grid ---
        // Usamos FlexLayout para crear un grid que se ajusta automáticamente.
        FlexLayout gridContainer = new FlexLayout();
        
        // Queremos que los items pasen a la siguiente línea si no caben.
        gridContainer.setFlexWrap(FlexLayout.FlexWrap.WRAP); 
        
        // Añadimos un poco de espacio entre los items.
        gridContainer.getStyle().set("gap", "1em"); 
        
        for (com.example.demo.domain.Youtuber youtuber : youtubers) {
            // Creamos una nueva instancia del item con datos de ejemplo
            Youtubersseguidos_item youtuberItem = new Youtubersseguidos_item(youtuber
            );

            // Añadimos el item a nuestro vector de referencias
            this._item.add(youtuberItem);

            // Añadimos el item al contenedor del grid visual
            gridContainer.add(youtuberItem);
        }
     
        // Finalmente, añadimos nuestro gridContainer (que ya tiene los 3 items)
        // al layout principal de la clase.
        add(gridContainer);
        
        // Opcional: Centrar el grid en la página
        setHorizontalComponentAlignment(Alignment.CENTER, gridContainer);
    }
}
}

 