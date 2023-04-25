package com.galmov.core.pq.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "seguimiento")
public class Seguimiento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String titulo;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String descripcion;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "fecha_realizado")
	@Temporal(TemporalType.DATE)
	private Date fechaRealizado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "solicitud_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Solicitud solicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRealizado() {
		return fechaRealizado;
	}

	public void setFechaRealizado(Date fechaRealizado) {
		this.fechaRealizado = fechaRealizado;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private static final long serialVersionUID = 1L;
}
