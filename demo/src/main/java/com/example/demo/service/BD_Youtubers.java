package com.example.demo.service;

import java.net.Authenticator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.RepositorioVideo;
import com.example.demo.domain.RepositorioYoutuber;
import com.example.demo.domain.Video;
import com.example.demo.domain.Youtuber;
import com.vaadin.flow.server.VaadinSession;

import io.netty.handler.codec.mqtt.MqttReasonCodes.Auth;

@Service
public class BD_Youtubers {
    public BDPrincipal _en;
    public Vector<Youtuber> _youtubers = new Vector<Youtuber>();
    final RepositorioYoutuber repository;
    private PasswordEncoder passwordEncoder;
    private RepositorioVideo respositoryvideo;
    

    public BD_Youtubers(RepositorioYoutuber repository, RepositorioVideo repositoryvideo, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.respositoryvideo = repositoryvideo;

    }

public Youtuber autenticar(String username, String rawPassword) {
        return repository.findById(username)
                .filter(youtuber -> passwordEncoder.matches(rawPassword, youtuber.getPassword()))
                .orElse(null);
    }

    public void actualizarConfiguracion(String value, String src, String src2) {
        Youtuber usuario = (Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuario.setPassword(passwordEncoder.encode(value));
        usuario.setFotoPerfil(src);
        usuario.setBanner(src2);
        repository.save(usuario);
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
        String PasswordEncoder = passwordEncoder.encode(password);
        nuevoYoutuber.setPassword(PasswordEncoder);
        nuevoYoutuber.setFotoPerfil(avatarUrl);
        nuevoYoutuber.setBanner(fondoUrl);
        nuevoYoutuber.setBloqueado(false);
        repository.save(nuevoYoutuber);
    }

    public List<Video> getYoutuberVideos(String login) {
        com.example.demo.domain.Youtuber usuario = repository.findById(login)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Vector<Video> UltimosVideos = new Vector<Video>();
        for (Object obj : usuario.getSeguidor_de()) {
        Youtuber seguido = (Youtuber) obj; // Cast explícito
        UltimosVideos.addAll(seguido.getHa_publicado());
    }
        UltimosVideos.addAll(usuario.getHa_publicado());
        return UltimosVideos;
    }

    public List<Youtuber> buscarDenunciados() {
        List<Youtuber> denunciados = repository.findAll();
        return denunciados.stream()
                .filter(youtuber -> youtuber.getDenunciado_por().size() > 0)
                .toList();
    }

    public void denunciarUsuario(String ormid) {
        Youtuber usuario = repository.findById(ormid)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Youtuber usuarioActual = (Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuario.getDenunciado_por().add(usuarioActual); // Asumiendo que hay un campo denunciado en Youtuber
        repository.save(usuario);
    }


    public void quitardenunciaUsuario(String ormid) {
        Youtuber usuario = repository.findById(ormid)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Youtuber usuarioActual = (Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuario.getDenunciado_por().remove(usuarioActual); // Asumiendo que hay un campo denunciado en Youtuber
        repository.save(usuario);
    }

    public void seguirUsuario(String ormid) {
        Youtuber usuario = repository.findById(ormid)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Youtuber usuarioActual = (Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuario.getSeguido_por().add(usuarioActual); // Asumiendo que hay un campo seguido_por en Youtuber
        repository.save(usuario);
    }

     public void dejardeseguirUsuario(String ormid) {
        Youtuber usuario = repository.findById(ormid)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Youtuber usuarioActual = (Youtuber) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuario.getSeguido_por().remove(usuarioActual); // Asumiendo que hay un campo seguido_por en Youtuber
        repository.save(usuario);
    }
 

    public Youtuber findYoutuberById(String parameter) {
        return repository.findById(parameter)
                .orElseThrow(() -> new RuntimeException("Youtuber no encontrado"));
    }

    public Set<Youtuber> getYoutubersSeguidos(String parameter) {
        Youtuber usuario = repository.findById(parameter)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuario.getSeguidor_de();
    }

    public void desbloquearUsuario(String ormid) {
          Youtuber usuario = repository.findById(ormid)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setBloqueado(false); // Asumiendo que hay un campo bloqueado en Youtuber
        repository.save(usuario);
    }

 
 
}