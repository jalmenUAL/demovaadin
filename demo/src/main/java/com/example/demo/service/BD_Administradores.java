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
    public List<Object> obtenerDenuncias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDenuncias'");
    }
    public iAdministrador buscarPorLoginYPassword(String login, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorLoginYPassword'");
    }
}