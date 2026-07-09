package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;

@Service
public class BD_Youtubers {
    public BDPrincipal _en;
    public Vector<Youtuber> _youtubers = new Vector<Youtuber>();
    final RepositorioYoutuber repository;
    private PasswordEncoder passwordEncoder;

    public BD_Youtubers(RepositorioYoutuber repository,
            PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
      

    }

    public Youtuber autenticar(String username, String rawPassword) {
        return repository.findById(username)
                .filter(youtuber -> passwordEncoder.matches(rawPassword, youtuber.getPassword()))
                .orElse(null);
    }

    public Youtuber findYoutuberById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Youtuber no encontrado"));
    }

    public void registrar(String login, String password, String avatarUrl, String fondoUrl) {
        Youtuber nuevoYoutuber = new Youtuber();
        nuevoYoutuber.setLogin(login);
        String PasswordEncoder = passwordEncoder.encode(password);
        nuevoYoutuber.setPassword(PasswordEncoder);
        nuevoYoutuber.setFotoPerfil(avatarUrl);
        nuevoYoutuber.setBanner(fondoUrl);
        nuevoYoutuber.setBloqueado(false);
        repository.save(nuevoYoutuber);
    }

    public void actualizarConfiguracion(Youtuber usuario,String password, String avatar, String fondo) {
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setFotoPerfil(avatar);
        usuario.setBanner(fondo);
        repository.save(usuario);
    }

    

    public List<Youtuber> buscarDenunciados() {
        List<Youtuber> denunciados = repository.findAll();
        return denunciados.stream()
                .filter(youtuber -> youtuber.getDenunciado_por().size() > 0)
                .toList();
    }

    public void seguirUsuario(Youtuber seguidor, Youtuber seguido) {
        seguido.getSeguido_por().add(seguidor); // Asumiendo que hay un campo seguido_por en Youtuber
        repository.save(seguido);
    }

    public void dejardeseguirUsuario(Youtuber seguidor, Youtuber seguido) {
        seguido.getSeguido_por().remove(seguidor); // Asumiendo que hay un campo seguido_por en Youtuber
        repository.save(seguido);
    }

    public void bloquearUsuario(Youtuber usuario) {
        usuario.setBloqueado(true); // Asumiendo que hay un campo bloqueado en Youtuber
        repository.save(usuario);
    }

    public void desbloquearUsuario(Youtuber usuario) {
        
        usuario.setBloqueado(false); // Asumiendo que hay un campo bloqueado en Youtuber
        repository.save(usuario);
    }

    public void denunciarUsuario(Youtuber denunciante, Youtuber denunciado) {
        denunciante.getDenunciado_por().add(denunciado);
        repository.save(denunciante);
    }

    public void quitardenunciaUsuario(Youtuber denunciante, Youtuber denunciado) {
        denunciante.getDenunciado_por().remove(denunciado);
        repository.save(denunciante);
    }
  

        public void likeVideo(Youtuber usuario, Video video) { 
        usuario.getLe_gusta().add(video);
        repository.save(usuario); // 💡 guardamos el dueño, no el inverso
    }

        public void dislikeVideo(Youtuber usuario, Video video) {
        usuario.getLe_gusta().remove(video);
        repository.save(usuario);
    }

    @Transactional   
    public void borrarMeGustaDeTodosLosUsuarios(Video video) {
           repository.findAll().forEach(usuario -> {
                if (usuario.getLe_gusta().contains(video)) {
                    usuario.getLe_gusta().remove(video);
                    //repository.save(usuario);
                }
            });
        }
 
      

    }

 
 
 