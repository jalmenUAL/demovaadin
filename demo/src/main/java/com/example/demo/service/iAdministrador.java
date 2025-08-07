package com.example.demo.service;

import java.util.List;

public interface iAdministrador extends iRegistrado {

    void bloquearUsuario(String ormid);

    static void denunciarUsuario(String ormid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'denunciarUsuario'");
    }

    static void seguirUsuario(String ormid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seguirUsuario'");
    }
   
}