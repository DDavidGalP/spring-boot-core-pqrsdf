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
import com.galmov.core.pq.app.model.entity.Estado;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_solicitud_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoSolicitud tipoSolicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dependencia_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Dependencia dependencia;
	
	

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;*/

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}


	private static final long serialVersionUID = 1L;

}
