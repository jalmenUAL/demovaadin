package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.domain.Administrador;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.AdministradorRepository;
import java.util.List;

@Service
public class AdministradorService {

    private final AdministradorRepository repository;

    public AdministradorService(AdministradorRepository repository) {
        this.repository = repository;
    }

    // Listar con paginación
    public List<Administrador> list(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    // Guardar un nuevo Administrador o actualizar uno existente
    public Administrador save(Administrador Administrador) {
        return repository.save(Administrador);
    }

    // Obtener un Administrador por su login
    public Administrador getByLogin(String login) {
        return repository.findById(login).orElse(null);
    }

    // Eliminar un Administrador por su login
    public void delete(String login) {
        repository.deleteById(login);
    }
}