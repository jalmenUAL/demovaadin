package com.example.demo.service;

import java.util.Optional;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioAdministrador;
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
 
}