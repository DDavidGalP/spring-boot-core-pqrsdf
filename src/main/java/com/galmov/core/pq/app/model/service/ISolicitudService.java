package com.galmov.core.pq.app.model.service;

import java.util.List;

import com.galmov.core.pq.app.model.entity.Solicitud;

public interface ISolicitudService {

	public List<Solicitud>findAll();
	public Solicitud findById(Long id);
	public Solicitud save(Solicitud solicitud);
	public void delete(Long id);
	
}
