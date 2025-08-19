package com.example.demo.service;


import com.example.demo.domain.Registrado;


public interface iNoLogueado extends iInicio {

    Registrado Login(String username, String password);

    void registrar(String login, String password, String avatarUrl, String fondoUrl);
}