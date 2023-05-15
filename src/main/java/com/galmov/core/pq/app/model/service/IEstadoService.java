package com.galmov.core.pq.app.model.service;

import java.util.List;

import com.galmov.core.pq.app.model.entity.Estado;



public interface IEstadoService {
	
	public List<Estado> findAll();
	public Estado findById(Long id);
	public Estado save(Estado estado);
	public void delete(Long id);

}
