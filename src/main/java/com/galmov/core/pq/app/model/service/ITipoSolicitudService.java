package com.galmov.core.pq.app.model.service;

import java.util.List;

import com.galmov.core.pq.app.model.entity.TipoSolicitud;



public interface ITipoSolicitudService {

	public List<TipoSolicitud> findAll();
	public TipoSolicitud findById(Long id);
	public TipoSolicitud save(TipoSolicitud tipoSolicitud);
	public void delete(Long id);
}
