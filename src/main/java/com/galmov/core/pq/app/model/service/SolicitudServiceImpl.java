package com.galmov.core.pq.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galmov.core.pq.app.model.dao.ISolicitudDao;
import com.galmov.core.pq.app.model.entity.Dependencia;
import com.galmov.core.pq.app.model.entity.Estado;
import com.galmov.core.pq.app.model.entity.Solicitud;
import com.galmov.core.pq.app.model.entity.TipoSolicitud;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

	@Autowired
	private ISolicitudDao solicitudDao;

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> findAll() {
		return (List<Solicitud>) solicitudDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Solicitud findById(Long id) {
		return solicitudDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Solicitud save(Solicitud solicitud) {
		return solicitudDao.save(solicitud);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		solicitudDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Estado> findAllEstados() {
		return solicitudDao.findAllEstados();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoSolicitud> findAllTipoSolitudes() {
		return solicitudDao.findAllTipoSolitudes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dependencia> findAllDependencias() {
		return solicitudDao.findAllDependencias();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Solicitud> findAll(Pageable pageable) {
		return solicitudDao.findAll(pageable);
	}

}
