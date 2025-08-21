package com.example.demo.views;

import java.util.List;

import com.example.demo.domain.Video;
import com.vaadin.flow.router.Route;

@Route("ResultadodeBusqueda")

public class ResultadodeBusqueda extends GaleradeVideos {
	public Buscar _buscar;

	public ResultadodeBusqueda(List<Video> resultados) {
		super(resultados);
		tituloGaleria.setText("Resultados de la búsqueda");
		carrusel.removeAll();

		for (Video video : resultados) {
			ResultadodeBusqueda_item gvi = new ResultadodeBusqueda_item(video);
			carrusel.add(gvi);
		}
	}
}