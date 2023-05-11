package com.galmov.core.pq.app.model.service;

import com.galmov.core.pq.app.model.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
