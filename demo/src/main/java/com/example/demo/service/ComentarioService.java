package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.domain.Comentario;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.ComentarioRepository;
import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    // Listar con paginación
    public List<Comentario> list(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    // Guardar un nuevo Comentario o actualizar uno existente
    public Comentario save(Comentario Comentario) {
        return repository.save(Comentario);
    }

    // Obtener un Comentario por su id
    public Comentario getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Eliminar un Comentario por su id
    public void delete(Long id) {
        repository.deleteById(id);
    }
}