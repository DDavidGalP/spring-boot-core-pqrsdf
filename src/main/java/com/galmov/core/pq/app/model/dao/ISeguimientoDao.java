package com.galmov.core.pq.app.model.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import com.galmov.core.pq.app.model.entity.Seguimiento;


public interface ISeguimientoDao extends JpaRepository<Seguimiento, Long>{

	/*	
	@Query("from solicitud")
	public List<Solicitud> findAllSolicitudes();

Optional<Seguimiento> findBySolicitudId(Solicitud solicitudId);
 * 
 * @Query("from TipoSolicitud")
	public List<TipoSolicitud> findAllTipoSolitudes();
	
	
	Optional<Seguimiento> findByUsuarioId(Usuario usuarioId);*/


}
