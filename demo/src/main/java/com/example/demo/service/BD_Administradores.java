package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Administrador;
import com.example.demo.domain.RepositorioAdministrador;



@Service
public class BD_Administradores {
	public BDPrincipal _en;
	public Vector<Administrador> _administradores = new Vector<Administrador>();
	private RepositorioAdministrador repository;
    private PasswordEncoder passwordEncoder;

    public BD_Administradores(RepositorioAdministrador administradoresRepository, @Lazy PasswordEncoder passwordEncoder) {
        //TODO Auto-generated constructor stub
        this.repository = administradoresRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Administrador autenticar(String username, String rawPassword) {

        return repository.findByLogin(username)
                .filter(administrador -> passwordEncoder.matches(rawPassword, administrador.getPassword()))
                .orElse(null);
    


    }
}