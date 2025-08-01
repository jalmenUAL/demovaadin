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
	
	@OneToMany(mappedBy="es_de", targetEntity=com.example.demo.domain.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ha_publicado = new java.util.HashSet();
	
	@OneToMany(mappedBy="escrito_por", targetEntity=com.example.demo.domain.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ha_comentado = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.example.demo.domain.Youtuber.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Registrado_Registrado", joinColumns={ @JoinColumn(name="RegistradoLogin2") }, inverseJoinColumns={ @JoinColumn(name="RegistradoLogin") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set seguido_por = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.example.demo.domain.Youtuber.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Registrado_Registrado2", joinColumns={ @JoinColumn(name="RegistradoLogin2") }, inverseJoinColumns={ @JoinColumn(name="RegistradoLogin") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set bloquedado_por = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.example.demo.domain.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Video_Registrado", joinColumns={ @JoinColumn(name="RegistradoLogin") }, inverseJoinColumns={ @JoinColumn(name="VideoId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set le_gusta = new java.util.HashSet();
	
	@ManyToMany(mappedBy="seguido_por", targetEntity=com.example.demo.domain.Youtuber.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set seguidor_de = new java.util.HashSet();
	
	@ManyToMany(mappedBy="bloquedado_por", targetEntity=com.example.demo.domain.Youtuber.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.FALSE)	
	private java.util.Set ha_bloqueado_a = new java.util.HashSet();
	
	public void setBloqueado(boolean value) {
		setBloqueado(Boolean.valueOf(value));
	}
	
	public void setBloqueado(Boolean value) {
		this.bloqueado = value;
	}
	
	public Boolean getBloqueado() {
		return bloqueado;
	}
	
	public void setHa_publicado(java.util.Set value) {
		this.ha_publicado = value;
	}
	
	public java.util.Set getHa_publicado() {
		return ha_publicado;
	}
	
	
	public void setHa_comentado(java.util.Set value) {
		this.ha_comentado = value;
	}
	
	public java.util.Set getHa_comentado() {
		return ha_comentado;
	}
	
	
	public void setSeguido_por(java.util.Set value) {
		this.seguido_por = value;
	}
	
	public java.util.Set getSeguido_por() {
		return seguido_por;
	}
	
	
	public void setBloquedado_por(java.util.Set value) {
		this.bloquedado_por = value;
	}
	
	public java.util.Set getBloquedado_por() {
		return bloquedado_por;
	}
	
	
	public void setLe_gusta(java.util.Set value) {
		this.le_gusta = value;
	}
	
	public java.util.Set getLe_gusta() {
		return le_gusta;
	}
	
	
	public void setSeguidor_de(java.util.Set value) {
		this.seguidor_de = value;
	}
	
	public java.util.Set getSeguidor_de() {
		return seguidor_de;
	}
	
	
	public void setHa_bloqueado_a(java.util.Set value) {
		this.ha_bloqueado_a = value;
	}
	
	public java.util.Set getHa_bloqueado_a() {
		return ha_bloqueado_a;
	}
	
	
	public String toString() {
		return super.toString();
	}
	
}
