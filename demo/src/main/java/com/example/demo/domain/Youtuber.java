/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: jalmen(University of Almeria)
 * License Type: Academic
 */
package com.example.demo.domain;

import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Youtuber")
public class Youtuber extends com.example.demo.domain.Registrado implements Serializable {
	public Youtuber() {
	}
	
	@Column(name="Bloqueado", nullable=true, length=1)	
	private Boolean bloqueado;
	
	@Column(name="Banner", nullable=true, length=255)	
	private String banner;
	
	@OneToMany(mappedBy="es_de", targetEntity=com.example.demo.domain.Video.class,cascade = CascadeType.ALL, orphanRemoval = true)	
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Video> ha_publicado = new java.util.HashSet();
	
	@OneToMany(mappedBy="escrito_por", targetEntity=com.example.demo.domain.Comentario.class,cascade = CascadeType.ALL, orphanRemoval = true)	
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Video> ha_comentado = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.example.demo.domain.Youtuber.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Registrado_Registrado", joinColumns={ @JoinColumn(name="RegistradoLogin2") }, inverseJoinColumns={ @JoinColumn(name="RegistradoLogin") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Youtuber> seguido_por = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.example.demo.domain.Youtuber.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Registrado_Registrado2", joinColumns={ @JoinColumn(name="RegistradoLogin2") }, inverseJoinColumns={ @JoinColumn(name="RegistradoLogin") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Youtuber> denunciado_por = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.example.demo.domain.Video.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Video_Registrado", joinColumns={ @JoinColumn(name="RegistradoLogin") }, inverseJoinColumns={ @JoinColumn(name="VideoId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Video> le_gusta = new java.util.HashSet();
	
	//@ManyToMany(mappedBy="seguido_por", targetEntity=com.example.demo.domain.Youtuber.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Youtuber> seguidor_de = new java.util.HashSet();
	
	//@ManyToMany(mappedBy="denunciado_por", targetEntity=com.example.demo.domain.Youtuber.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set<Youtuber> ha_denunciado_a = new java.util.HashSet();
	
	public void setBloqueado(boolean value) {
		setBloqueado(Boolean.valueOf(value));
	}
	
	public void setBloqueado(Boolean value) {
		this.bloqueado = value;
	}
	
	public Boolean getBloqueado() {
		return bloqueado;
	}
	
	public void setBanner(String value) {
		this.banner = value;
	}
	
	public String getBanner() {
		return banner;
	}
	
	public void setHa_publicado(java.util.Set<Video> value) {
		this.ha_publicado = value;
	}
	
	public java.util.Set<Video> getHa_publicado() {
		return ha_publicado;
	}
	
	
	public void setHa_comentado(java.util.Set<Video> value) {
		this.ha_comentado = value;
	}
	
	public java.util.Set<Video> getHa_comentado() {
		return ha_comentado;
	}
	
	
	public void setSeguido_por(java.util.Set<Youtuber> value) {
		this.seguido_por = value;
	}
	
	public java.util.Set<Youtuber> getSeguido_por() {
		return seguido_por;
	}
	
	
	public void setDenunciado_por(java.util.Set<Youtuber> value) {
		this.denunciado_por = value;
	}
	
	public java.util.Set<Youtuber> getDenunciado_por() {
		return denunciado_por;
	}
	
	
	public void setLe_gusta(java.util.Set<Video> value) {
		this.le_gusta = value;
	}
	
	public java.util.Set<Video> getLe_gusta() {
		return le_gusta;
	}
	
	
	public void setSeguidor_de(java.util.Set<Youtuber> value) {
		this.seguidor_de = value;
	}
	
	public java.util.Set<Youtuber> getSeguidor_de() {
		return seguidor_de;
	}
	
	
	public void setHa_denunciado_a(java.util.Set<Youtuber> value) {
		this.ha_denunciado_a = value;
	}
	
	public java.util.Set<Youtuber> getHa_denunciado_a() {
		return ha_denunciado_a;
	}
	
	
	public String toString() {
		return super.toString();
	}

	
}
