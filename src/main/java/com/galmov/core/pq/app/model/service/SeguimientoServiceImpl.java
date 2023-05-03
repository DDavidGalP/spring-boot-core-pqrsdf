package com.galmov.core.pq.app.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galmov.core.pq.app.model.dao.ISeguimientoDao;
import com.galmov.core.pq.app.model.dao.ISolicitudDao;
import com.galmov.core.pq.app.model.entity.Seguimiento;
import com.galmov.core.pq.app.model.entity.Solicitud;

@Service
public class SeguimientoServiceImpl implements ISeguimientoService{

	@Autowired
	private ISeguimientoDao seguimientoDao;
	
	@Autowired ISolicitudDao solicitudDao;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Seguimiento> findAll() {
		return (List<Seguimiento>) seguimientoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Seguimiento findById(Long id) {
		return seguimientoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Seguimiento save(Seguimiento seguimiento) {	
		return seguimientoDao.save(seguimiento);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		seguimientoDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Solicitud findSolicitudById(Long id) {
		return solicitudDao.findById(id).orElse(null);
	}
	
	
	/* @Override
	
	public Solicitud saveSolicitud(Solicitud solicitud) {
		return solicitudDao.save(solicitud);
	}

	@Override
	public void deleteSolicidutId(long id) {
	solicitudDao.deleteById(null);
	}

	/*@Override
	

	
	/*@Override
	
	@Override
	@Transactional(readOnly = true)
	public Page<Solicitud> findAll(Pageable pageable) {
		return solicitudDao.findAll(pageable);
	}

	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Seguimiento> findByUsuarioId(Usuario usuarioId) {
		return seguimientoDao.findByUsuarioId(usuarioId);
	}*/
}
