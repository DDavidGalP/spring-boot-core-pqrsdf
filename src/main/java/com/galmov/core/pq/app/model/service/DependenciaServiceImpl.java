package com.galmov.core.pq.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galmov.core.pq.app.model.dao.IDependenciaDao;
import com.galmov.core.pq.app.model.entity.Dependencia;

@Service
public class DependenciaServiceImpl implements IDependenciaService{

	@Autowired
	private IDependenciaDao dependenciaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Dependencia> findAll() {
		return (List<Dependencia>) dependenciaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Dependencia findById(Long id) {
		return dependenciaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Dependencia save(Dependencia dependencia) {
		return dependenciaDao.save(dependencia);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dependenciaDao.deleteById(id);
		
	}

}
