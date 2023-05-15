package com.galmov.core.pq.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galmov.core.pq.app.model.dao.IEstadoDao;
import com.galmov.core.pq.app.model.entity.Estado;

@Service
public class EstadoServiceImpl implements IEstadoService{

	@Autowired
	private IEstadoDao estadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Estado> findAll() {	
		return (List<Estado>) estadoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Estado findById(Long id) {
		return estadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Estado save(Estado estado) {
		return estadoDao.save(estado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		estadoDao.deleteById(id);
		
	}
	
}
