package com.galmov.core.pq.app.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.galmov.core.pq.app.model.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	
	public Usuario findByUsername(String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
	//public Usuario findByUsernameAndEmail(String username, String email);
	//@Query("select u from Usuario u where u.username=?1 andu.otro=?2")
}
