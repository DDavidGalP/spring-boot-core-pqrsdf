package com.galmov.core.pq.app.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.galmov.core.pq.app.model.entity.Seguimiento;
import com.galmov.core.pq.app.model.entity.Solicitud;
import com.galmov.core.pq.app.model.entity.Usuario;



public interface ISeguimientoService {

	public List<Seguimiento>findAll();
	public Seguimiento findById(Long id);
	public Seguimiento save(Seguimiento seguimiento);
	public void delete(Long id);
	public Solicitud findSolicitudById(Long id);
	//public List<Solicitud> findAllSolicitud();
	/*Optional<Seguimiento> findBySolicitudId(Solicitud solicitudId);
	Optional<Seguimiento> findByUsuarioId(Usuario usuarioId);*/

	
}
