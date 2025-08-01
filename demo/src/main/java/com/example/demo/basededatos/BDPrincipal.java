package com.example.demo.basededatos;



public class BDPrincipal implements iNoLogueado, iYoutuber, iAdministrador, iRegistrado, iInicio {
	public BD_Videos _videos;
	public BD_Comentarios _comentarios;
	public BD_Youtubers _youtubers;
	public BD_Administradores _administradores;
}