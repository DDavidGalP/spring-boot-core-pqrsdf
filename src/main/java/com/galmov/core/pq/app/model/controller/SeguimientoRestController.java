package com.galmov.core.pq.app.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.galmov.core.pq.app.model.entity.Seguimiento;
import com.galmov.core.pq.app.model.service.ISolicitudService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class SeguimientoRestController {

	@Autowired
	private ISolicitudService solicitudService;
	
	@Secured({"ROLE_ADMIN", "ROLE_TECNICO"})
	@GetMapping("/seguimientos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Seguimiento show(@PathVariable Long id) {
		return solicitudService.findSeguimientoById(id);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_TECNICO"})
	@PostMapping("/seguimientos")
	@ResponseStatus(HttpStatus.CREATED)
	public Seguimiento crear(@RequestBody Seguimiento seguimiento) {
		return solicitudService.saveSeguimiento(seguimiento);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_TECNICO"})
	@DeleteMapping("/seguimientos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		solicitudService.deleteSeguimientoById(id);
	}
	
}
