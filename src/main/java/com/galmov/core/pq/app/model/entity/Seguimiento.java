package com.galmov.core.pq.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String respuesta;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "fecha_realizado")
	@Temporal(TemporalType.DATE)
	private Date fechaRealizado;

	@JsonIgnoreProperties(value = { "seguimientos", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Solicitud solicitud;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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

	private static final long serialVersionUID = 1L;
}
