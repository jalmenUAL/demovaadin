package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdministradorRepository extends JpaRepository<Administrador, String>, JpaSpecificationExecutor<Administrador> {

	 
}

