package com.galmov.core.pq.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.galmov.core.pq.app.model.entity.Dependencia;
import com.galmov.core.pq.app.model.entity.Estado;
import com.galmov.core.pq.app.model.entity.Solicitud;
import com.galmov.core.pq.app.model.entity.TipoSolicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long>{

	@Query("from Estado")
	public List<Estado> findAllEstados();
	
	@Query("from TipoSolicitud")
	public List<TipoSolicitud> findAllTipoSolitudes();
	
	@Query("from Dependencia")
	public List<Dependencia> findAllDependencias();
	
}
