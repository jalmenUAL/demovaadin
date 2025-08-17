package com.example.demo.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.GrantedAuthority;

public interface RepositorioRegistrado extends JpaRepository<Registrado, String>, JpaSpecificationExecutor<Registrado> {

     
}

