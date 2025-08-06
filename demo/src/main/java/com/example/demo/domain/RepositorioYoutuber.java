package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioYoutuber extends JpaRepository<Youtuber, String>, JpaSpecificationExecutor<Youtuber> {

    Optional<Youtuber> findByLogin(String username);

    
    
    // Puedes agregar más métodos personalizados si es necesario

    

	 
}

