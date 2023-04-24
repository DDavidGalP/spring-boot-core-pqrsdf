package com.galmov.core.pq.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galmov.core.pq.app.model.entity.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long>{

}
