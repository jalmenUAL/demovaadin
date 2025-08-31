package com.example.demo.views;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("UltimosVideos")
public class UltimosVideos extends GaleradeVideos {
	public Inicio _inicio;

	/* Tiene como parámetro la lista de videos */

	public UltimosVideos(List<Video> videos) {
		super(videos);

		tituloGaleria.setText("Últimos Videos");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.isAuthenticated()) {

		boolean esAdmin = auth.getAuthorities().stream()
				.anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"));
		boolean esYoutuber = auth.getAuthorities().stream()
				.anyMatch(a -> a.getAuthority().equals("ROLE_YOUTUBER"));

		/* Dependiendo del usuario muestra unos items u otros */

		if (esAdmin) {
			for (Video video : videos) {
				UltimosVideos_item item = new UltimosVideosdeAdministrador_item(video);
				carrusel.add(item);
			}
		} else if (esYoutuber) {
			for (Video video : videos) {
				UltimosVideos_item item = new UltimosVideosdeYoutuber_item(video);
				carrusel.add(item);
			}
		} else {
			for (Video video : videos) {
				UltimosVideos_item item = new UltimosVideos_item(video);
				carrusel.add(item);
			}
		}
	}

	}
}