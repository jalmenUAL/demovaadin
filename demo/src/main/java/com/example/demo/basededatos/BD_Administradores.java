package com.example.demo.basededatos;

import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Administrador;
import com.example.demo.domain.AdministradorRepository;

@Service
public class BD_Administradores {
	public BDPrincipal _en;
	public Vector<Administrador> _administradores = new Vector<Administrador>();
	private AdministradorRepository repository;
}