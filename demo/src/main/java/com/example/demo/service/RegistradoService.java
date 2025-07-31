package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.domain.Registrado;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.RegistradoRepository;
import java.util.List;

@Service
public class RegistradoService {

    private final RegistradoRepository repository;

    public RegistradoService(RegistradoRepository repository) {
        this.repository = repository;
    }

    // Listar con paginación
    public List<Registrado> list(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    // Guardar un nuevo Registrado o actualizar uno existente
    public Registrado save(Registrado Registrado) {
        return repository.save(Registrado);
    }

    // Obtener un Registrado por su URL
    public Registrado getById(String login) {
        return repository.findById(login).orElse(null);
    }

    // Eliminar un Registrado por su URL
    public void delete(String login) {
        repository.deleteById(login);
    }
}