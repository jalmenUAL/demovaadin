package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Administrador;
import com.example.demo.domain.RepositorioAdministrador;

@Service
public class BD_Administradores {
	public BDPrincipal _en;
	public Vector<Administrador> _administradores = new Vector<Administrador>();
	private RepositorioAdministrador repository;
    public BD_Administradores(RepositorioAdministrador administradoresRepository) {
        //TODO Auto-generated constructor stub
        this.repository = administradoresRepository;
    }
}