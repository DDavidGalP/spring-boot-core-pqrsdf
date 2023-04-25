package com.galmov.core.pq.app.model.service;

import java.util.List;

import com.galmov.core.pq.app.model.entity.Dependencia;
import com.galmov.core.pq.app.model.entity.Estado;
import com.galmov.core.pq.app.model.entity.Solicitud;
import com.galmov.core.pq.app.model.entity.TipoSolicitud;

public interface ISolicitudService {

	public List<Solicitud>findAll();
	public Solicitud findById(Long id);
	public Solicitud save(Solicitud solicitud);
	public void delete(Long id);
	public List<Estado> findAllEstados();
	public List<TipoSolicitud> findAllTipoSolitudes();
	public List<Dependencia> findAllDependencias();
	
}
