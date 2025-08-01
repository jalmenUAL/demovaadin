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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Comentario")
public class Comentario implements Serializable {
	public Comentario() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_EXAMPLE_DEMO_DOMAIN_COMENTARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_EXAMPLE_DEMO_DOMAIN_COMENTARIO_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity=com.example.demo.domain.Youtuber.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="RegistradoLogin", referencedColumnName="Login", nullable=false) }, foreignKey=@ForeignKey(name="FKComentario549922"))	
	private com.example.demo.domain.Youtuber escrito_por;
	
	@ManyToOne(targetEntity=com.example.demo.domain.Video.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="VideoId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="FKComentario671331"))	
	private com.example.demo.domain.Video sobre;
	
	@Column(name="Texto", nullable=true, length=255)	
	private String texto;
	
	public void setTexto(String value) {
		this.texto = value;
	}
	
	public String getTexto() {
		return texto;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setSobre(com.example.demo.domain.Video value) {
		this.sobre = value;
	}
	
	public com.example.demo.domain.Video getSobre() {
		return sobre;
	}
	
	public void setEscrito_por(com.example.demo.domain.Youtuber value) {
		this.escrito_por = value;
	}
	
	public com.example.demo.domain.Youtuber getEscrito_por() {
		return escrito_por;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
