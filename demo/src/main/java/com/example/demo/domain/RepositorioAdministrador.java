package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioAdministrador extends JpaRepository<Administrador, String>, JpaSpecificationExecutor<Administrador> {

    Optional<Administrador> findByLogin(String username);

	 
}

