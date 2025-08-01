package com.example.demo.basededatos;

import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.AdministradorRepository;
import com.example.demo.domain.Video;
import com.example.demo.domain.VideoRepository;

@Service

public class BD_Videos {
	public BDPrincipal _en;
	public Vector<Video> _videos = new Vector<Video>();
	private VideoRepository repository;
	
}