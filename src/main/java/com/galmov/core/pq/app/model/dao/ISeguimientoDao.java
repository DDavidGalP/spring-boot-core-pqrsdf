package com.galmov.core.pq.app.model.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galmov.core.pq.app.model.entity.Seguimiento;
import com.galmov.core.pq.app.model.entity.Solicitud;
import com.galmov.core.pq.app.model.entity.Usuario;

public interface ISeguimientoDao extends JpaRepository<Seguimiento, Long>{
	
	@Query("from solicitud")
	public List<Solicitud> findAllSolicitud();
	
/*	Optional<Seguimiento> findBySolicitudId(Solicitud solicitudId);
	
	Optional<Seguimiento> findByUsuarioId(Usuario usuarioId);*/


}
