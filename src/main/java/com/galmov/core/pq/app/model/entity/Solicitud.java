package com.galmov.core.pq.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "no puede estar vacio")
	@Column(nullable = false)
	private Long codigo;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String descripcion;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String titulo;

	
	@NotNull(message = "no puede estar vacio")
	@Column(name = "fecha_solicitud")
	@Temporal(TemporalType.DATE)
	private Date fechaSolicitud;
	
	
	@NotNull(message = "no puede estar vacio")
	@Column(name = "fecha_finalizado")
	@Temporal(TemporalType.DATE)
	private Date fechaFinalizado;

	
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public Date getFechaFinalizado() {
		return fechaFinalizado;
	}


	public void setFechaFinalizado(Date fechaFinalizado) {
		this.fechaFinalizado = fechaFinalizado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}








	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
