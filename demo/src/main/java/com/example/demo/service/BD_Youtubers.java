package com.example.demo.service;

import java.util.Vector;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Youtuber;

import com.example.demo.domain.RepositorioYoutuber;

@Service
public class BD_Youtubers {
    public BDPrincipal _en;
    public Vector<Youtuber> _youtubers = new Vector<Youtuber>();
    private final RepositorioYoutuber repository;

    public BD_Youtubers(RepositorioYoutuber repository) {
        this.repository = repository;

    }

    public Youtuber autenticar(String username, String password) {
         
    return repository.findByLogin(username)
            .filter(youtuber -> youtuber.getPassword().equals(password))
            .orElse(null);

    }

    public void actualizarConfiguracion(String value, String value2, String src, String src2) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Youtuber usuario = repository.findByLogin(login)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setLogin(value);
        usuario.setPassword(value2);
        usuario.setFotoPerfil(src);
        usuario.setBanner(src2);
        repository.save(usuario);
    }
 
}