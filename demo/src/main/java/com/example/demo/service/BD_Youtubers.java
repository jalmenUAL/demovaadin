package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

@Service
public class BD_Youtubers {
    public BDPrincipal _en;
    public Vector<Youtuber> _youtubers = new Vector<Youtuber>();
    private final RepositorioYoutuber repository;
    private PasswordEncoder passwordEncoder;
    

    public BD_Youtubers(RepositorioYoutuber repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

public Youtuber autenticar(String username, String rawPassword) {
        return repository.findByLogin(username)
                .filter(youtuber -> passwordEncoder.matches(rawPassword, youtuber.getPassword()))
                .orElse(null);
    }

    public void actualizarConfiguracion(String value, String value2, String src, String src2) {
         
    }

    public void bloquearUsuario(String ormid) {
        Youtuber usuario = repository.findById(ormid)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setBloqueado(true); // Asumiendo que hay un campo bloqueado en Youtuber
        repository.save(usuario);
    }
 

    public void registrar(String login, String password, String avatarUrl, String fondoUrl) {
        Youtuber nuevoYoutuber = new Youtuber();
        nuevoYoutuber.setLogin(login);
        nuevoYoutuber.setPassword(password);
        nuevoYoutuber.setFotoPerfil(avatarUrl);
        nuevoYoutuber.setBanner(fondoUrl);
        repository.save(nuevoYoutuber);
    }

    public List<Video> cargarUltimosVideos(String login) {
        com.example.demo.domain.Youtuber usuario = repository.findByLogin(login)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Vector<Video> UltimosVideos = new Vector<Video>();
        for (Object obj : usuario.getSeguidor_de()) {
        Youtuber seguido = (Youtuber) obj; // Cast explícito
        UltimosVideos.addAll(seguido.getHa_publicado());
    }
        return UltimosVideos;
    }

    public List<Youtuber> buscarDenunciados() {
        List<Youtuber> denunciados = repository.findAll();
        return denunciados.stream()
                .filter(Youtuber::getBloqueado) // Asumiendo que hay un método getBloqueado en Youtuber
                .toList();
    }
 
}