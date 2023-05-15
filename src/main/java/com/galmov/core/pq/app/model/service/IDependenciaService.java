package com.galmov.core.pq.app.model.service;

import java.util.List;

import com.galmov.core.pq.app.model.entity.Dependencia;



public interface IDependenciaService {

	public List<Dependencia> findAll();
	public Dependencia findById(Long id);
	public Dependencia save(Dependencia dependencia);
	public void delete(Long id);
}
