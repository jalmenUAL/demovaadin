package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioComentario extends JpaRepository<Comentario, Long>, JpaSpecificationExecutor<Comentario> {

    Optional<Comentario> findById(int id);
}

