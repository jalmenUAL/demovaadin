package com.example.demo.service;

import java.util.List;

public interface iAdministrador extends iRegistrado {
    // Bloquear un usuario por su login
    void bloquearUsuarioPorLogin(String login);

    // Ver denuncias de usuarios (puedes definir el tipo Denuncia según tu modelo)
    List<Object> verDenunciasUsuarios();

    // Buscar un administrador por login y password
    iAdministrador buscarAdministradorPorLoginYPassword(String login, String password);
}