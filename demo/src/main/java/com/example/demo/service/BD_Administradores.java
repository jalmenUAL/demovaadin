package com.example.demo.service;

import java.util.Vector;

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

    /* Le hace falta acceder al repositorio de administradores y al password encoder */


    public BD_Administradores(RepositorioAdministrador administradoresRepository, PasswordEncoder passwordEncoder) {

        this.repository = administradoresRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Administrador autenticar(String username, String rawPassword) {
        System.out.println(rawPassword);
        return repository.findById(username)
                .filter(admin -> passwordEncoder.matches(rawPassword, admin.getPassword()))
                .orElse(null);

    }
}