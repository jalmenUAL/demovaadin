package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.domain.Video;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.VideoRepository;
import java.util.List;

@Service
public class VideoService {

    private final VideoRepository repository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    // Listar con paginación
    public List<Video> list(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    // Guardar un nuevo video o actualizar uno existente
    public Video save(Video video) {
        return repository.save(video);
    }

    // Obtener un video por su id
    public Video getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Eliminar un video por su id
    public void delete(Long id) {
        repository.deleteById(id);
    }
}