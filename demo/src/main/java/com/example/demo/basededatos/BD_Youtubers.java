package com.example.demo.basededatos;

import java.util.Vector;

import org.springframework.stereotype.Service;

import com.example.demo.domain.AdministradorRepository;
import com.example.demo.domain.Youtuber;
import com.example.demo.domain.YoutuberRepository;

@Service

public class BD_Youtubers {
	public BDPrincipal _en;
	public Vector<Youtuber> _youtubers = new Vector<Youtuber>();
	private YoutuberRepository repository;
}