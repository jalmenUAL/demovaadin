package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Administrador;
import com.example.demo.domain.RepositorioAdministrador;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Youtuber;

import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RepositorioAdministrador adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final RepositorioYoutuber youtuberRepo;

    public DataInitializer(RepositorioAdministrador adminRepo, RepositorioYoutuber youtuberRepo, PasswordEncoder passwordEncoder) {
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
        this.youtuberRepo = youtuberRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificar si existe un admin
        if (adminRepo.findByLogin("admin").isEmpty()) {
            Administrador admin = new Administrador();
            admin.setLogin("admin");
            admin.setPassword(passwordEncoder.encode("admin123")); // siempre cifrar
            
            adminRepo.save(admin);

            System.out.println("✅ Usuario administrador creado: admin / admin123");
        }

        
        if (youtuberRepo.findByLogin("youtuber").isEmpty()) {
            Youtuber youtuber = new Youtuber();
            youtuber.setLogin("youtuber");
            youtuber.setPassword(passwordEncoder.encode("youtuber123")); // siempre cifrar

            youtuberRepo.save(youtuber);

            System.out.println("✅ Usuario youtuber creado: youtuber / youtuber123");
        }
    }
}

