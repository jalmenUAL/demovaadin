package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.domain.Youtuber;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.YoutuberRepository;
import java.util.List;

@Service
public class YoutuberService {

    private final YoutuberRepository repository;

    public YoutuberService(YoutuberRepository repository) {
        this.repository = repository;
    }

    // Listar con paginación
    public List<Youtuber> list(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    // Guardar un nuevo Youtuber o actualizar uno existente
    public Youtuber save(Youtuber Youtuber) {
        return repository.save(Youtuber);
    }

    // Obtener un Youtuber por su login
    public Youtuber getByUrl(String login) {
        return repository.findById(login).orElse(null);
    }

    // Eliminar un Youtuber por su login
    public void delete(String login) {
        repository.deleteById(login);
    }
}